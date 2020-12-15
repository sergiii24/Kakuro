package domini.millores;

import domini.*;
import domini.models.Position;

import java.util.*;

public class MonteState implements INmcsState<Tauler, Pair<Position, Integer>> {

    private int blank;
    private final Casella[][] board;

    public MonteState(Casella[][] board) {

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


    @Override
    public double getScore() {
        return blank;
    }


    //TODO
    @Override
    public boolean isTerminalPosition() {
        if (blank != 0) return false;
        //if (emptyDomain()) return true;
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

    //Ha de retornar totes les accions possibles del taullel tot i que he implementat que retorne totes les accions possibles dintre del domini més menut
    @Override
    public List<Pair<Position, Integer>> findAllLegalActions() {

        List<Pair<Position, Integer>> pairList = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].isBlanc() && ((Blanc) board[i][j]).getNum() == 0) {
                    for (int n : ((Blanc) board[i][j]).getPossibles()) {
                        if (isValidMove(board, i, j, n)) pairList.add(new Pair<>(new Position(i, j), n));
                    }
                }

            }
        }

        return pairList;

    }

    //TODO
    @Override
    public INmcsState<Tauler, Pair<Position, Integer>> takeAction(Pair<Position, Integer> action) {

        Casella[][] casellas = clonar(this.board);
        ((Blanc) casellas[action.item1.i][action.item1.j]).setNum(action.item2);
        update(casellas, action.item1.i, action.item1.j, action.item2);
        return new MonteState(casellas);

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



    //TODO
    @Override
    public Pair<Double, List<Pair<Position, Integer>>> simulation() {

        final List<Pair<Position, Integer>> simulation = new LinkedList<>();
        final Casella[][] tempBoard = clonar(this.board);
        List<Pair<Position, Integer>> groups = findAllLegalMoves(tempBoard);
        while (groups.size() > 0) {
            final Pair<Position, Integer> randomMove = groups.get(new Random().nextInt(groups.size()));
            ((Blanc)tempBoard[randomMove.item1.i][randomMove.item1.j]).setNum(randomMove.item2);
            update(tempBoard, randomMove.item1.i, randomMove.item1.j, randomMove.item2);
            simulation.add(randomMove);
            groups = findAllLegalMoves(tempBoard);
        }
        return Pair.of((double)getScore(tempBoard), simulation);

    }

    private List<Pair<Position, Integer>> findAllLegalMoves(Casella[][] c) {

        int best = 10;
        int a = 0, b = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if (c[i][j].isBlanc() && ((Blanc) c[i][j]).getNum() == 0 && ((Blanc) c[i][j]).getPossibles().size() < best) {
                    a = i;
                    b = j;
                    best = ((Blanc) c[i][j]).getPossibles().size();
                }
            }
        }

        List<Pair<Position, Integer>> pairList = new LinkedList<>();

        if(best != 10) {
            for (int n : ((Blanc) c[a][b]).getPossibles()) {
                if(isValidMove(c, a, b, n)) pairList.add(new Pair<>(new Position(a, b), n));
            }

        }
        return pairList;

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


    public Set<Integer> evalDomain(int i, int j) {

        Set<Integer> re = new HashSet<>();
        re.addAll(colCon(i, j));
        re.retainAll(rowCon(i, j));
        return re;

    }

    public Set<Integer> colCon(int i, int j) {

        int aux = i;

        while (board[aux][j].isBlanc()) aux--;
        int digits = 0;
        int num = ((Negre) board[aux][j]).getColumna();
        aux++;
        ArrayList<Integer> list = new ArrayList<>();
        while (aux < board.length && board[aux][j].isBlanc()) {
            if (((Blanc) board[aux][j]).getNum() != 0) list.add(((Blanc) board[aux][j]).getNum());
            digits++;
            aux++;
        }

        Set<Integer> set = CombiGenerator.combinationSum2(num, digits);
        for (int n : list) {
            set.remove(n);
        }

        return set;

    }

    public Set<Integer> rowCon(int i, int j) {

        int aux = j;

        while (board[i][aux].isBlanc()) aux--;
        int digits = 0;
        int num = ((Negre) board[i][aux]).getFila();
        aux++;
        ArrayList<Integer> list = new ArrayList<>();
        while (aux < board[0].length && board[i][aux].isBlanc()) {
            if (((Blanc) board[i][aux]).getNum() != 0) list.add(((Blanc) board[i][aux]).getNum());
            digits++;
            aux++;
        }
        Set<Integer> set = CombiGenerator.combinationSum2(num, digits);
        for (int n : list) {
            set.remove(n);
        }

        return set;
    }


    private int getScore(Casella[][] c) {

        int score = 0;

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if (c[i][j].isBlanc() && ((Blanc)c[i][j]).getNum()==0 ) score++;
            }
        }

        if(inconsitent()) return score+10;

        return score;

    }


}
