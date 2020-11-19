import classes.*;

import java.util.Scanner;
import java.util.Set;

public class Kakuro {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        //Reader r = new Reader("src/data/exemple");

        //Board b = new Board(r.llegirFitxer());
        //b.updatePossibilities();
        int[] nums = {1,2,3,4,5,6,7,8,9};

        Set<Integer> set = CombiGenerator.combinationSum2( nums ,  scanner.nextInt() , scanner.nextInt());
        System.out.println(set.toString());

        //Generator g = new Generator();
        //Tauler t = new Tauler(g.getCasseles(9,9));
        //System.out.println(t.toString());
        //Solver solver = new Solver();
        //solver.solve(t);
        //System.out.println(t.toString());
        /*Generador gen = new Generador();
        gen.llegir_tamany();
        gen.generar();*/


    }

}
