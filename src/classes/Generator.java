package classes;


import java.util.Random;

public class Generator {

    public Casella[][] getCasseles(int a, int b) {
        
        Casella[][] c = obteBasic(a,b);
        System.out.println(1);
        genNumCaselles(c,a,b);
        System.out.println(2);
        fillKakuro(c, a, b);
        System.out.println(new Tauler(c).toString());
        suma(c,a,b);
        System.out.println(4);
        return generar(c,a,b);

    }

    private Casella[][] fillKakuro(Casella[][] c, int a, int b) {

        Random random = new Random();
        for (int i=0;i<a;i++) {
            for (int j = 0; j < b;) {
                if (c[i][j].isBlanc()) {
                    int num = random.nextInt(9)+1;
                    if(checkSudoku(c,i,j,num)) {
                        ((Blanc)c[i][j]).setNum(num);
                        j++;
                    }
                } else j++;
            }
        }

        return c;

    }


    private Casella[][] obteBasic(int a, int b) {

        Casella[][] casellas = new Casella[a][b];

        for (int i=0;i<a;i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || j == 0) casellas[i][j] = new Negre();
                else casellas[i][j] = new Blanc();
            }
        }

        return casellas;

    }


    private void genNumCaselles(Casella[][] c, int a, int b) {

        Random random = new Random();
        int num =  random.nextInt((int)(a*b*0.6)-(int)(a*b*0.4))+(int)(a*b*0.4);
        int row, col;
        int aux = 0;

        for (int i = 0; i < num && aux < 100;) {

            row = random.nextInt(a);
            col = random.nextInt(b);
            aux++;

            if (c[row][col].isBlanc() && checkConstraints(c, row, col, a, b) && isConnected(c,a,b,new Position(row,col),((a-1)*(b-1)-i))) {
                c[row][col] = new Negre();
                i++;
                aux=0;
            }

        }

    }

    private boolean checkConstraints(Casella[][] c, int row, int col, int a, int b) {

        if(col+1<b && c[row][col+1].isBlanc() && ( col+2==b || c[row][col+2].isNegre())) return false;
        if(col-1>0 && c[row][col-1].isBlanc() && (col-2==0 || c[row][col-2].isNegre())) return false;
        if(row+1<b && c[row+1][col].isBlanc() && (row+2==a || c[row+2][col].isNegre())) return false;
        if(row-1>0 && c[row-1][col].isBlanc() && (row-2==0 || c[row-2][col].isNegre())) return false;
        return true;
    }


    public boolean checkSudoku(Casella[][] array, int row, int col, int num) {

        boolean fin_dreta = false;
        boolean fin_esquerra = false;

        for (int i = 0; i<array[0].length && (!fin_dreta || !fin_esquerra); i++) {
            if (!fin_dreta && col+i < array[0].length) {
                if (array[row][col + i].isBlanc()) {
                    if (((Blanc) array[row][col + i]).getNum() == num) return false;
                }
                else fin_dreta = true;
            }
            if (!fin_esquerra) {
                if (array[row][col - i].isBlanc()) {
                    if (((Blanc) array[row][col - i]).getNum() == num) return false;
                }
                else fin_esquerra = true;
            }
        }

        boolean fin_baix = false;
        boolean fin_dalt = false;

        for (int i = 0; i<array.length && (!fin_baix || !fin_dalt); i++) {
            if (!fin_baix && row+i < array[0].length) {
                if (array[row + i][col].isBlanc()) {
                    if (((Blanc) array[row+i][col]).getNum() == num) return false;
                }
                else fin_baix = true;
            }
            if (!fin_dalt) {
                if (array[row-i][col].isBlanc()) {
                    if (((Blanc) array[row-i][col]).getNum() == num) return false;
                }
                else fin_dalt = true;
            }
        }


        return true;

    }

    private boolean isConnected(Casella[][] c, int a, int b, Position nova, int num){

        boolean found = false;
        Position p = null;
        int i=1;
        int j=1;
        while(!found) {
                if(c[i][j].isBlanc()) {
                    p = new Position(i, j);
                    found = true;
                } else {
                    if(j+1<b)j++;
                    else {
                        j=1;
                        i++;
                    }
                }
        }


        //created visited array
        boolean[][] visited = new boolean[a][b];

        //start the DFS from vertex 0
        DFS(p.getI(), p.getJ(), c, visited, nova);

        //check if all the vertices are visited, if yes then graph is connected
        int count = 0;
        for (int k = 0; k < a; k++) {
            for (int l = 0; l < b; l++) {
                if(visited[k][l])
                    count++;
            }
        }

        return num-1==count;
    }

    private void DFS(int i, int j, Casella[][] c, boolean[][] visited, Position p){

        //mark the vertex visited
        visited[i][j] = true;

        //travel the neighbors
        //North
        if (i - 1 != p.getI() || j != p.getJ()) {
            if (i-1>=0 && c[i-1][j].isBlanc() && !visited[i-1][j]) DFS(i-1, j, c, visited, p);
        }
        //South
        if (i + 1 != p.getI() || j != p.getJ()) {
            if (i + 1 < c.length && c[i + 1][j].isBlanc() && !visited[i + 1][j]) DFS(i + 1, j, c, visited, p);
        }
        //East
        if (i != p.getI() || j+1 != p.getJ()) {
            if (j + 1 < c[0].length && c[i][j + 1].isBlanc() && !visited[i][j + 1]) DFS(i, j + 1, c, visited, p);
        }
        //West
        if (i != p.getI() || j - 1 != p.getJ()) {
            if (j - 1 >= 0 && c[i][j - 1].isBlanc() && !visited[i][j - 1]) DFS(i, j - 1, c, visited, p);
        }
    }

    private void suma(Casella[][] c, int a, int b) {

        int r = 0, s = 0, suma = 0;

        boolean nou = false;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(c[i][j].isNegre()){
                    if(nou) {
                        ((Negre)c[r][s]).setFila(suma);
                        suma = 0;
                        nou = false;
                    }
                    r = i;
                    s = j;
                } else {
                    suma+=((Blanc)c[i][j]).getNum();
                    nou = true;
                }
            }
        }

        if(nou)
            ((Negre)c[r][s]).setFila(suma);

        r = 0;
        s = 0;
        suma = 0;
        nou = false;

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                if(c[j][i].isNegre()){
                    if(nou) {
                        ((Negre)c[r][s]).setColumna(suma);
                        suma = 0;
                        nou = false;
                    }
                    r = j;
                    s = i;
                } else {
                    suma+=((Blanc)c[j][i]).getNum();
                    nou = true;
                }
            }
        }

        if(nou)
            ((Negre)c[r][s]).setColumna(suma);


    }

    private Casella[][] generar(Casella[][] c, int a, int b) {

        Casella[][] nou = new Casella[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(c[i][j].isNegre()){
                    nou[i][j] = new Negre(((Negre)c[i][j]).getColumna(),((Negre)c[i][j]).getFila());
                } else {
                    nou[i][j] = new Blanc();
                }
            }
        }

        return nou;

    }


}
