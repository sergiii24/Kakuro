package domini.models;

import domini.Blanc;
import domini.Casella;
import domini.CombiGenerator;
import domini.Negre;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MonteState implements INmcsState<MonteState, Action> {

    private int blank;
    private Casella[][] board;

    public MonteState(Casella[][] board) {

        this.board = new Casella[board.length][board[0].length];
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



    @Override
    public double getScore() {
        return blank;
    }


    //TODO
    @Override
    public boolean isTerminalPosition() {
        return false;
    }

    //TODO
    @Override
    public List<Action> findAllLegalActions() {
        return null;
    }


    //TODO
    @Override
    public INmcsState<MonteState, Action> takeAction(Action action) {
        return null;
    }

    //TODO
    @Override
    public Pair<Double, List<Action>> simulation() {
        return null;
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




}
