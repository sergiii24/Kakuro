package domini;

import domini.models.Position;
import domini.models.State;

public class Sample {



    public int sample(State s) {

        while(true) {
            Position p = s.bestPosition();
            for(int n : ((Blanc)s.getBoard()[p.i][p.j]).getPossibles()) {


            }




        }



    }


}
