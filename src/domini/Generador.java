package domini;

import domini.models.Position;

import java.util.Random;

public class Generador {

    public Casella[][] generateKakuro(int a, int b) {

        //1r - Obté tauler bàsic de mida a*b amb la primera fila i columna negra
        Casella[][] c = getBasic(a,b);

        //2n - Genera entre un 20% i un 40% de caselles negres aleatori en el tauler,
        //aquestes éstan colocades mantenint un kakuro connex i correcte amb un mínim
        // de dos caselles blanques juntes
        generateBlackCells(c,a,b);

        //3r - Omple les caselles blanques amb números generats aleatoriament sense repeticions
        //entre files i columnes (volem modificar aquesta part per a que tingue en compte el domini)
        fillKakuro(c, a, b);

        //4rt - Actualitza les caselles negres sumants les files i columnes pertinents
        sumKakuro(c,a,b);

        //5é - Genera el taulell final amb les cel·les blanques buides
        return generate(c,a,b);

    }

    //Genera Bàsic
    private Casella[][] getBasic(int a, int b) {

        Casella[][] casellas = new Casella[a][b];

        for (int i=0;i<a;i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || j == 0) casellas[i][j] = new Negre();
                else casellas[i][j] = new Blanc();
            }
        }

        return casellas;

    }

    //Genera les caselles negres aleatoriament
    private void generateBlackCells(Casella[][] c, int a, int b) {

        Random random = new Random();
        //Genera un numero que està entre el 40% i 20% del total de caselles, volem que modificant aquest
        //nombre el kakuro serà més fàcil o més díficil
        int num =  random.nextInt((int)(a*b*0.4)-(int)(a*b*0.2))+(int)(a*b*0.2);
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

    //Retorna cert si la cel·la generada compleix que al seu costat té una casella negra o
    //en cas que sigue blanca en hi ha un mínim de dos
    private boolean checkConstraints(Casella[][] c, int row, int col, int a, int b) {

        if(col+1<b && c[row][col+1].isBlanc() && ( col+2==b || c[row][col+2].isNegre())) return false;
        if(col-1>0 && c[row][col-1].isBlanc() && (col-2==0 || c[row][col-2].isNegre())) return false;
        if(row+1<a && c[row+1][col].isBlanc() && (row+2==a || c[row+2][col].isNegre())) return false;
        if(row-1>0 && c[row-1][col].isBlanc() && (row-2==0 || c[row-2][col].isNegre())) return false;

        return true;

    }

    //Metode que comprova que el conjunt de caselles blanques estiguin connectades,
    //mitjançant un dfs i comprovant que el numero de celes blanques visitades és igual
    //al numero total de celes blanques del taulell
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


        //Creacio de la matriu de visitats
        boolean[][] visited = new boolean[a][b];

        //Començament del dfs des de la primera
        DFS(p.getI(), p.getJ(), c, visited, nova);

        //Comprova tots els grafs visitats si suma igual que els totals, el taulell està conectat
        int count = 0;
        for (int k = 0; k < a; k++) {
            for (int l = 0; l < b; l++) {
                if(visited[k][l])
                    count++;
            }
        }

        return num-1==count;
    }

    //Metode recursiu Deep First Search
    private void DFS(int i, int j, Casella[][] c, boolean[][] visited, Position p){

        //Hem visitat la casella
        visited[i][j] = true;

        //Es propaga als veïns
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


    //Omple el taulem amb números aleatoris no repetits per files i columnes
    private Casella[][] fillKakuro(Casella[][] c, int a, int b) {

        Random random = new Random();
        for (int i=0;i<a;i++) {
            for (int j = 0; j < b;) {
                if (c[i][j].isBlanc()) {
                    int num = random.nextInt(9)+1;
                    if(checkKakuro(c,i,j,num)) {
                        ((Blanc)c[i][j]).setNum(num);
                        j++;
                    }
                } else j++;
            }
        }

        return c;

    }

    //Comprova que el numero col·locat no està ja a la columna i a la fila
    public boolean checkKakuro(Casella[][] array, int row, int col, int num) {

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
            if (!fin_baix && row+i < array.length) {
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


    //Suma les files i les columnes i actualitza aquesta informació a les caselles negres pertinents
    private void sumKakuro(Casella[][] c, int a, int b) {

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

    //Genera el taulell buït amb l'estructura i el format adient
    private Casella[][] generate(Casella[][] c, int a, int b) {

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
