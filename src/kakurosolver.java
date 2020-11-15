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
        int n = s.solve(t);
        if(n >= 2) System.out.println(2);
        else if(n == 1) System.out.println(1);
        else System.out.println(0);
        /*Generador gen = new Generador();
        gen.llegir_tamany();
        gen.generar();*/


    }

}
