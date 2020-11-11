import classes.Generador;
import classes.Reader;

import java.util.Scanner;

public class Kakuro {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Reader r = new Reader("/home/jonsnow/Desktop/Kakuro-master/src/data/exemple");

        r.llegirFitxer();
        
        /*Generador gen = new Generador();
        gen.llegir_tamany();
        gen.generar();*/


    }

}
