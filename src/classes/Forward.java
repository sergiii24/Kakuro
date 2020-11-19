package classes;

import java.util.List;

public class Forward {

    public boolean ForwardChecking (Casella[][] board) {

        if(isFilled(board)) return true;

        Position pos = bestPosition(board);
        List<Integer> domain = ((Blanc)board[pos.i][pos.j]).getPossibles();

        for (int n: domain ) {

            ((Blanc) board[pos.i][pos.j]).setNum(n);
            update(board, pos.i, pos.j, n);

            if (keepPlaying(board, pos.i, pos.j))
                if (ForwardChecking (board))
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
                if (board[i][j].isBlanc() && ((Blanc)board[i][j]).getPossibles().size() < best) {
                    a=i;
                    b=i;
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
        int i = 0;

        while (!fi_1 || !fi_2 || !fi_3 || !fi_4) {

            if (!fi_1) {
                if(b+i < board[0].length) {
                    if (board[a][b + i].isBlanc() && ((Blanc) board[a][b + i]).getPossibles().size() == 0) return false;
                } else fi_1 = true;
            } else fi_1 = true;

            if (!fi_2) {
                if (board[a][b - i].isBlanc() && ((Blanc) board[a][b - i]).getPossibles().size() == 0) return false;
                else {
                    fi_2 = true;
                    j_col = b-i;
                }
            }

            if (!fi_3) {
                if(a+i < board.length) {
                    if (board[a+i][b].isBlanc() && ((Blanc) board[a+i][b]).getPossibles().size() == 0) return false;
                    else fi_3 = true;
                } else fi_3 = true;
            }

            if (!fi_4) {
                if (board[a-i][b].isBlanc() && ((Blanc) board[a-i][b]).getPossibles().size() == 0) return false;
                else {
                    i_fil = a-i;
                    fi_4 = true;
                }
            }

            i++;

        }

        int total = ((Negre)board[a][j_col]).getColumna();
        int sum = 0;
        j_col++;

        while((board[a][j_col]).isBlanc()) {
            sum += ((Blanc)board[a][j_col]).getNum();
            j_col++;
        }

        if(sum>total) return false;

        total = ((Negre)board[i_fil][b]).getFila();
        sum = 0;
        i_fil++;

        while((board[i_fil][b]).isBlanc()) {
            sum += ((Blanc)board[i_fil][a]).getNum();
            i_fil++;
        }

        return sum<total;

    }


}

