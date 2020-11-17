import classes.Generador;
import classes.Reader;
import classes.Solver;
import classes.Tauler;

import java.util.Scanner;

public class kakurosolver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Reader r = new Reader();
        
        Tauler t = r.llegirFitxer();
        
        Solver s = new Solver();
        long l1 = System.currentTimeMillis();
        int n = s.solve(t);
        System.out.println(System.currentTimeMillis() - l1);
        if(n >= 2) {
        	System.out.println(2);
        	//System.out.println(t.toString());
        }
        else if(n == 1) System.out.println(1);
        else System.out.println(0);
        /*Generador gen = new Generador();
        gen.llegir_tamany();
        gen.generar();*/


    }

}
