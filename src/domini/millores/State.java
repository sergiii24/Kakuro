package domini.millores;

import domini.Blanc;
import domini.Casella;
import domini.CombiGenerator;
import domini.Negre;
import domini.models.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class State {

    private int blank;
    private Casella[][] board;

    public State() {}

    public void setBlank(int blank) {
        this.blank = blank;
    }

    public void setBoard(Casella[][] board) {
        this.board = board;
    }

    public State(Casella[][] board) {

        this.board = new Casella[board.length][board[0].length];
        this.blank = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].isNegre()) {
                    this.board[i][j] = new Negre(((Negre) board[i][j]).getColumna(), ((Negre) board[i][j]).getFila());
                } else {
                    this.board[i][j] = new Blanc(((Blanc) board[i][j]).getNum());
                    if(((Blanc)this.board[i][j]).getNum()==0) {
                        ((Blanc) this.board[i][j]).setPossibles(((Blanc) board[i][j]).getPossibles());
                        blank++;
                    }
                }
            }
        }


    }

    public Position bestPosition() {

        if(blank==0) return new Position(0,0);
        int best = 10;
        int a = 0, b = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].isBlanc() && ((Blanc)board[i][j]).getNum()==0 && ((Blanc)board[i][j]).getPossibles().size() < best) {
                    a=i;
                    b=j;
                    best = ((Blanc)board[i][j]).getPossibles().size();
                }
            }
        }
        return new Position(a,b);
    }

    private boolean isValidMove(Casella[][] c, int a, int b, int n) {

        return validColumna(c,a,b,n)&&validFila(c,a,b,n);

    }

    private boolean validColumna(Casella[][] c , int i, int j, int num) {

        int aux = i;

        while(c[aux][j].isBlanc()) aux--;
        int total = ((Negre)c[aux][j]).getColumna();
        aux++;
        int blanc = 0;
        int suma = 0;
        while (aux<c.length && c[aux][j].isBlanc()) {
            if(((Blanc)c[aux][j]).getNum()!=0) suma += ((Blanc)c[aux][j]).getNum();
            else blanc++;
            aux++;
        }

        if(blanc==1) return total==suma+num;
        return (total-suma) >= num;

    }

    private boolean validFila(Casella[][] c , int i, int j, int num) {

        int aux = j;

        while(c[i][aux].isBlanc()) aux--;
        int total = ((Negre)c[i][aux]).getFila();
        aux++;
        int blanc = 0;
        int suma = 0;
        while (aux<c[0].length && c[i][aux].isBlanc()) {
            if(((Blanc)c[i][aux]).getNum()!=0) suma += ((Blanc)c[i][aux]).getNum();
            else blanc++;
            aux++;
        }
        if(blanc==1) return total==suma+num;
        return (total-suma) >= num;

    }



    private Casella[][] clonar (Casella[][] c) {

        Casella[][] casellas = new Casella[c.length][c[0].length];

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if (c[i][j].isNegre()) {
                    casellas[i][j] = new Negre(((Negre) c[i][j]).getColumna(), ((Negre) c[i][j]).getFila());
                } else {
                    casellas[i][j] = new Blanc(((Blanc) c[i][j]).getNum());
                    if(((Blanc)casellas[i][j]).getNum()==0) ((Blanc) casellas[i][j]).setPossibles(((Blanc) c[i][j]).getPossibles());
                }
            }
        }

        return casellas;

    }

    private void setPos(Casella[][] casellas) {
        for (int i = 0; i < casellas.length; i++) {
            for (int j = 0; j < casellas[0].length; j++) {
                if(casellas[i][j].isBlanc() && ((Blanc)casellas[i][j]).getNum() == 0) {
                    ((Blanc)casellas[i][j]).setPossibles(evalDomain(i, j));
                }
            }
        }


    }



    public ArrayList<State> nextStates(Position r){

        ArrayList<State> nSs = new ArrayList<>();


        for (int k : ((Blanc)this.board[r.getI()][r.getJ()]).getPossibles()) {

            if(isValidMove(this.board, r.i, r.j, k)) {
                Casella[][] v = clonar(this.board); //copy of board
                ((Blanc) v[r.getI()][r.getJ()]).setNum(k);
                update(v, r.getI(), r.getJ(), k);
                nSs.add(new State(v));
            }
        }

        return nSs;

    }

    private void update(Casella[][] board, int a, int b, int value) {

        boolean fi_1 = false;
        boolean fi_2 = false;
        boolean fi_3 = false;
        boolean fi_4 = false;
        int i = 0;

        while (!fi_1 || !fi_2 || !fi_3 || !fi_4) {

            if (!fi_1) {
                if(b+i < board[0].length) {
                    if (board[a][b + i].isBlanc() ) {
                        if( board[a][b + i].isEmpty()) ((Blanc) board[a][b + i]).getPossibles().remove(value);
                    } else fi_1 = true;
                } else fi_1 = true;
            }

            if (!fi_2) {
                if (board[a][b - i].isBlanc()) {
                    if ( board[a][b - i].isEmpty()) ((Blanc) board[a][b - i]).getPossibles().remove(value);
                } else {
                    fi_2 = true;
                }
            }

            if (!fi_3) {
                if(a+i < board.length) {
                    if (board[a+i][b].isBlanc()) {
                        if (board[a+i][b].isEmpty())((Blanc) board[a+i][b]).getPossibles().remove(value);
                    } else fi_3 = true;
                } else fi_3 = true;
            }

            if (!fi_4) {
                if (board[a-i][b].isBlanc()) {
                    if( board[a-i][b].isEmpty())((Blanc) board[a-i][b]).getPossibles().remove(value);
                } else {
                    fi_4 = true;
                }
            }

            i++;

        }


    }




    public Set<Integer> evalDomain(int i, int j){

        Set<Integer> re = new HashSet<>();
        re.addAll(colCon(i,j));
        re.retainAll(rowCon(i,j));
        return re;

    }

    public Set<Integer> colCon(int i, int j){

        int aux = i;

        while(board[aux][j].isBlanc()) aux--;
        int digits = 0;
        int num = ((Negre)board[aux][j]).getColumna();
        aux++;
        ArrayList<Integer> list = new ArrayList<>();
        while (aux<board.length && board[aux][j].isBlanc()) {
            if(((Blanc)board[aux][j]).getNum()!=0) list.add(((Blanc)board[aux][j]).getNum());
            digits++;
            aux++;
        }

        Set<Integer> set = CombiGenerator.combinationSum2(num, digits);
        for (int n : list) {
            set.remove(n);
        }

        return set;

    }

    public Set<Integer> rowCon(int i, int j){

        int aux = j;

        while(board[i][aux].isBlanc()) aux--;
        int digits = 0;
        int num = ((Negre)board[i][aux]).getFila();
        aux++;
        ArrayList<Integer> list = new ArrayList<>();
        while (aux<board[0].length && board[i][aux].isBlanc()) {
            if(((Blanc)board[i][aux]).getNum()!=0) list.add(((Blanc)board[i][aux]).getNum());
            digits++;
            aux++;
        }
        Set<Integer> set = CombiGenerator.combinationSum2(num, digits);
        for (int n : list) {
            set.remove(n);
        }

        return set;
    }

    public Set<Integer> evalDom(Casella[][] c, int i, int j){

        Set<Integer> re = new HashSet<>();
        re.addAll(colCon(i,j));
        re.retainAll(rowCon(i,j));
        return re;

    }

    public Set<Integer> col(Casella[][] c, int i, int j){

        int aux = i;

        while(c[aux][j].isBlanc()) aux--;
        int digits = 0;
        int num = ((Negre)c[aux][j]).getColumna();
        aux++;
        ArrayList<Integer> list = new ArrayList<>();
        while (aux<c.length && c[aux][j].isBlanc()) {
            if(((Blanc)c[aux][j]).getNum()!=0) list.add(((Blanc)c[aux][j]).getNum());
            digits++;
            aux++;
        }

        Set<Integer> set = CombiGenerator.combinationSum2(num, digits);
        for (int n : list) {
            set.remove(n);
        }

        return set;

    }

    public Set<Integer> row( Casella[][] c, int i, int j){

        int aux = j;

        while(c[i][aux].isBlanc()) aux--;
        int digits = 0;
        int num = ((Negre)c[i][aux]).getFila();
        aux++;
        ArrayList<Integer> list = new ArrayList<>();
        while (aux<c[0].length && c[i][aux].isBlanc()) {
            if(((Blanc)c[i][aux]).getNum()!=0) list.add(((Blanc)c[i][aux]).getNum());
            digits++;
            aux++;
        }
        Set<Integer> set = CombiGenerator.combinationSum2(num, digits);
        for (int n : list) {
            set.remove(n);
        }

        return set;
    }

    public boolean isTerminalPosition() {
        if (blank != 0) return false;
        if (emptyDomain()) return false;
        return inconsitent();
    }

    private boolean inconsitent() {

        int r = 0, s = 0, suma = 0;
        boolean nou = false;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if (this.board[i][j].isNegre()) {

                    if (nou) {
                        if (((Negre) this.board[r][s]).getFila() != suma) return false;
                        suma = 0;
                        nou = false;
                    }

                    r = i;
                    s = j;

                } else {
                    suma += ((Blanc) this.board[i][j]).getNum();
                    nou = true;
                }
            }
        }

        if (nou)
            if (((Negre) this.board[r][s]).getFila() != suma) return false;

        r = 0;
        s = 0;
        suma = 0;
        nou = false;

        for (int i = 0; i < this.board[0].length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[j][i].isNegre()) {
                    if (nou) {
                        if (((Negre) this.board[r][s]).getColumna() != suma) return false;
                        suma = 0;
                        nou = false;
                    }
                    r = j;
                    s = i;
                } else {
                    suma += ((Blanc) this.board[j][i]).getNum();
                    nou = true;
                }
            }
        }

        if (nou)
            return ((Negre) this.board[r][s]).getColumna() == suma;


        return true;

    }


    private boolean emptyDomain() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].isBlanc() && ((Blanc) board[i][j]).getNum() == 0 && ((Blanc) board[i][j]).getPossibles().isEmpty()) return true;
            }
        }

        return false;

    }



    private boolean keepPlaying(Casella[][] board, int a, int b) {

        boolean fi_1 = false;
        boolean fi_2 = false;
        boolean fi_3 = false;
        boolean fi_4 = false;
        int j_col = 0, i_fil=0;
        int i = 1;

        while (!fi_1 || !fi_2) {

            /*if (!fi_1) {
                if (b + i < board[0].length) {
                    if (board[a][b + i].isBlanc()) {
                        if(((Blanc) board[a][b + i]).getPossibles().size() == 0) return false;
                    } else fi_1 = true;
                } else fi_1 = true;
            }*/

            if (!fi_1) {
                if (board[a][b-i].isNegre()) {
                    fi_1 = true;
                    j_col = b-i;
                }
            }

            /*if (!fi_3) {
                if(a+i < board.length) {
                    if (board[a+i][b].isBlanc() && ((Blanc) board[a+i][b]).getPossibles().size() == 0) return false;
                    else fi_3 = true;
                } else fi_3 = true;
            }*/

            if (!fi_2) {
                if (board[a-i][b].isNegre()) {
                    fi_2 = true;
                    i_fil = a-i;
                }
            }

            i++;

        }

        int total = ((Negre)board[a][j_col]).getFila();
        int sum = 0;
        j_col++;

        while(j_col < board[0].length && (board[a][j_col]).isBlanc()) {
            sum += ((Blanc)board[a][j_col]).getNum();
            j_col++;
        }

        if(sum>total) return false;

        total = ((Negre)board[i_fil][b]).getColumna();
        sum = 0;
        i_fil++;

        while(i_fil < board.length && (board[i_fil][b]).isBlanc()) {
            sum += ((Blanc)board[i_fil][b]).getNum();
            i_fil++;
        }

        return sum<=total;

    }


    public boolean isCompleted() {
        return blank==0;
    }

    public boolean isSatisfied() {

        int r = 0, s = 0, suma = 0;

        boolean nou = false;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if(this.board[i][j].isNegre()){
                    if(nou) {
                        if(((Negre)this.board[r][s]).getFila() != suma) return false;
                        suma = 0;
                        nou = false;
                    }
                    r = i;
                    s = j;
                } else {
                    suma+=((Blanc)this.board[i][j]).getNum();
                    nou = true;
                }
            }
        }

        if(nou)
            if(((Negre)this.board[r][s]).getFila() != suma) return false;

        r = 0;
        s = 0;
        suma = 0;
        nou = false;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if(this.board[j][i].isNegre()){
                    if(nou) {
                        if(((Negre)this.board[r][s]).getColumna() != suma) return false;
                        suma = 0;
                        nou = false;
                    }
                    r = j;
                    s = i;
                } else {
                    suma+=((Blanc)this.board[j][i]).getNum();
                    nou = true;
                }
            }
        }

        if(nou)
            return ((Negre) this.board[r][s]).getColumna() == suma;


            return true;

    }



    public Casella[][] getBoard() {
        return board;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.blank;
        hash = 89 * hash + Arrays.deepHashCode(this.board);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (this.blank != other.blank) {
            return false;
        }
        for (int k = 0; k < this.board.length; k++) {
            for (int l = 0; l < this.board[0].length; l++) {
                if(this.board[k][l].isBlanc() && ((Blanc)this.board[k][l]).getNum() != ((Blanc)other.board[k][l]).getNum()) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[0].length; l++) {
                out += this.board[k][l].toString() + ", ";
            }
            out += "\n";
        }
        out += "\n---------\n";
        return out;
    }

    public int getBlank() {
        return blank;
    }


}
