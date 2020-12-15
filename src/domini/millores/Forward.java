package domini.millores;

import domini.Blanc;
import domini.Casella;
import domini.Negre;
import domini.models.Position;

import java.util.Stack;

public class Forward {

    private final Stack<State> stack = new Stack<>();
    private State current;
    int i = 0;
    public State getCurrent() {
        return current;
    }

    public boolean ForwardChecking (State r) {

        if(r.isCompleted())  {
            current = r;
            return true;
        }

        Position pos = bestPosition(r.getBoard());

        for (State n : r.nextStates(pos)) {

            if (keepPlaying(n.getBoard(), pos.i, pos.j))
                if (ForwardChecking (n))
                    return true;

        }

        return false;

    }

    private boolean isFilled(Casella[][] board) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if(board[i][j].isEmpty()) return false;

        return true;

    }

    public Position bestPosition(Casella[][] board) {

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

    private void update(Casella[][] board, int a, int b, int value) {

        boolean fi_1 = false;
        boolean fi_2 = false;

        int i = 0;

        while (!fi_1 || !fi_2) {

            if (!fi_1) {
                if(b+i < board[0].length) {
                    if (board[a][b + i].isBlanc()) {
                        ((Blanc) board[a][b + i]).getPossibles().remove(value);
                    } else fi_1 = true;
                } else fi_1 = true;
            }

            if (!fi_2) {
                if (board[a][b - i].isBlanc()) ((Blanc) board[a][b - i]).getPossibles().remove(value);
                else fi_2 = true;
            }

            i++;

        }

        fi_1 = false;
        fi_2 = false;
        i = 0;

        while (!fi_1 || !fi_2) {

            if (!fi_1) {
                if(b+i < board.length) {
                    if (board[a+i][b].isBlanc()) {
                        ((Blanc) board[a+i][b]).getPossibles().remove(value);
                    } else fi_1 = true;
                } else fi_1 = true;
            }

            if (!fi_2) {
                if (board[a-i][b].isBlanc()) ((Blanc) board[a-i][b]).getPossibles().remove(value);
                else fi_2 = true;
            }

            i++;

        }

    }

    private boolean keepPlaying(Casella[][] board, int a, int b) {

        boolean fi_1 = false;
        boolean fi_2 = false;
        boolean fi_3 = false;
        boolean fi_4 = false;
        int j_col = 0, i_fil=0;
        int i = 1;

        while (!fi_1 || !fi_2 || !fi_3 || !fi_4) {

            if (!fi_1) {
                if(b+i < board[0].length) {
                    if (board[a][b + i].isBlanc() ) {
                            if( board[a][b + i].isEmpty() && ((Blanc) board[a][b + i]).getPossibles().size() == 0) return false;
                    } else fi_1 = true;
                } else fi_1 = true;
            }

            if (!fi_2) {
                if (board[a][b - i].isBlanc()) {
                    if ( board[a][b - i].isEmpty() && ((Blanc) board[a][b-i]).getPossibles().size() == 0) return false;
                } else {
                    fi_2 = true;
                    j_col = b-i;
                }
            }

            if (!fi_3) {
                if(a+i < board.length) {
                    if (board[a+i][b].isBlanc()) {
                        if (board[a+i][b].isEmpty() && ((Blanc) board[a + i][b]).getPossibles().size() == 0) return false;
                    } else fi_3 = true;
                } else fi_3 = true;
            }

            if (!fi_4) {
                if (board[a-i][b].isBlanc()) {
                    if( board[a-i][b].isEmpty() && ((Blanc) board[a-i][b]).getPossibles().size() == 0) return false;
                } else {
                    i_fil = a-i;
                    fi_4 = true;
                }
            }

            i++;

        }

        int total = ((Negre)board[a][j_col]).getFila();
        int sum = 0;
        j_col++;
        boolean complet = true;

        while(j_col < board[0].length && (board[a][j_col]).isBlanc()) {
            sum += ((Blanc)board[a][j_col]).getNum();
            if(board[a][j_col].isEmpty()) complet = false;
            j_col++;
        }

        if(complet && sum!=total) return false;
        if(sum>total) return false;

        total = ((Negre)board[i_fil][b]).getColumna();
        sum = 0;
        i_fil++;
        complet = true;

        while(i_fil < board.length && (board[i_fil][b]).isBlanc()) {
            sum += ((Blanc)board[i_fil][b]).getNum();
            if(board[i_fil][b].isEmpty()) complet = false;
            i_fil++;
        }

        if(complet && sum!=total) return false;
        return sum<=total;

    }


}

