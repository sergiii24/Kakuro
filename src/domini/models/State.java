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

    public static final int BSIZE = 9;
    private int blank;
    private Casella[][] board;
    private State parent;
    private ArrayList<State> children;

    public State(Casella[][] board) {

        this.board = new Casella[BSIZE][BSIZE];
        this.children = new ArrayList<>();
        this.blank = 0;
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                if(board[i][j].isNegre()){
                    this.board[i][j] = new Negre(((Negre)board[i][j]).getColumna(),((Negre)board[i][j]).getFila());
                } else {
                    this.board[i][j] = new Blanc(((Blanc)board[i][j]).getNum());
                }
            }
        }

        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
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


    public ArrayList<State> nextStates(State now){
        ArrayList<State> nSs = new ArrayList<>();
        State nS = null;
        Casella[][] v = new Casella[BSIZE][BSIZE]; //copy of board
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                if (board[i][j].isNegre()) {
                    v[i][j] = new Negre(((Negre) board[i][j]).getColumna(), ((Negre) board[i][j]).getFila());
                } else {
                    v[i][j] = new Blanc(((Blanc) board[i][j]).getNum());
                }
            }
        }
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                if(this.board[i][j].isBlanc() && ((Blanc)this.board[i][j]).getNum() == 0) {
                    ((Blanc)this.board[i][j]).setPossibles(evalDomain(i, j));
                }
            }
        }
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                if(this.board[i][j].isBlanc() && ((Blanc)this.board[i][j]).getNum() == 0){
                    for (int k : ((Blanc)this.board[i][j]).getPossibles()) {
                        nS = new State(v);
                        ((Blanc)nS.board[i][j]).setNum(k);
                        nSs.add(nS);
                    }
                    i = BSIZE;
                    j = BSIZE;
                }
            }
        }
        return nSs;
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


    public boolean isSatisfied(){
        if(this.blank > 1) return false;
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
                //if(this.board[k][l].getValue() != other.board[k][l].getValue()) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (int k = 0; k < BSIZE; k++) {
            for (int l = 0; l < BSIZE; l++) {
                //out += this.board[k][l].getValue() + ", ";
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
