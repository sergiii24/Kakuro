package domini.models;

import domini.Blanc;
import domini.Casella;
import domini.CombiGenerator;
import domini.Negre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class State {

    public static final int BSIZE = 7;
    private int blank;
    private Casella[][] board;
    private State parent;
    private ArrayList<State> children;

    public State(Casella[][] board) {

        this.board = new Casella[board.length][board[0].length];
        this.children = new ArrayList<>();
        this.blank = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j].isNegre()){
                    this.board[i][j] = new Negre(((Negre)board[i][j]).getColumna(),((Negre)board[i][j]).getFila());
                } else {
                    this.board[i][j] = new Blanc(((Blanc)board[i][j]).getNum());
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(this.board[i][j].isBlanc() && ((Blanc)this.board[i][j]).getNum() == 0) {
                    this.blank++;
                    ((Blanc)this.board[i][j]).setPossibles(evalDomain(i, j));
                }
            }
        }


    }


    public boolean isPossNode(boolean isForwardChecking){
        //forward checking
        if(isForwardChecking){
            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < BSIZE; j++) {
                    if(this.board[i][j].isBlanc() && ((Blanc)board[i][j]).getNum() == 0){
                        if(evalDomain(i, j).isEmpty()){
                            return false;
                        }
                    }
                }
            }
        }
        if(this.blank > 1) return true;
        return false;
    }

    private Casella[][] clonar(Casella[][] casellas) {
        Casella[][] v = new Casella[casellas.length][casellas[0].length]; //copy of board
        for (int i = 0; i < casellas.length; i++) {
            for (int j = 0; j < casellas[0].length; j++) {
                if (casellas[i][j].isNegre()) {
                    v[i][j] = new Negre(((Negre) casellas[i][j]).getColumna(), ((Negre) casellas[i][j]).getFila());
                } else {
                    v[i][j] = new Blanc(((Blanc) casellas[i][j]).getNum());
                }
            }
        }
        return v;
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

            //Casella[][] v = clonar(this.board); //copy of board
            ((Blanc)this.board[r.getI()][r.getJ()]).setNum(k);
            //setPos(v);
            //update(v, r.getI(), r.getJ(), k);
            nSs.add(new State(this.getBoard()));

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
            if(((Negre)this.board[r][s]).getColumna() != suma) return false;


            return true;

    }



    public Casella[][] getBoard() {
        return board;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }

    public State getParent() {
        return parent;
    }

    public void addChildren(State st){
        this.children.add(st);
    }

    public ArrayList<State> getChildren() {
        return children;
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
        for (int k = 0; k < BSIZE; k++) {
            for (int l = 0; l < BSIZE; l++) {
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
