/*
package classes;

import java.util.List;

public class Forward {

    Board board;

    public boolean ForwardChecking () {

        if(board.isFilled()) return true;

        Position pos = board.bestPosition();
        List<Integer> domain = board.getPossibilities(pos);
        for (int n: domain ) {
            board.setVariable(pos, n);
            board.update();
            if (board.keepPlaying())
                if (ForwardChecking ())
                    return true;
        }

        return false;

    }




}

        5 for all values in the domain of var
        6 assign value to var
        7 update the domains of the free variables
*/
