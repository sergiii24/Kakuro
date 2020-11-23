import dades.Reader;
import dades.Writer;
import domini.Generador;
import domini.Tauler;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kakuro {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        Reader r = new Reader();
        Generador g = new Generador();
        Writer writer = new Writer();

        while (true) {

            System.out.println("1 - Generar Kakuros Consola\n" +
                    "2 - Generar Kakuros Fitxer\n" +
                    "3 - Generar i Solucionar Kakuro\n" +
                    "4 - Solucionar Kakuro Consola\n" +
                    "5 - Solucionar Kakuro Exemple\n");
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Introdueix Files i Columnes (Més gran que 2)");
                    Tauler t = new Tauler(g.generateKakuro(scanner.nextInt(), scanner.nextInt()));
                    writer.escriureConsola(t);
                    break;
                case 2:
                    System.out.println("Introdueix Files i Columnes (Més gran que 2)");
                    Tauler tauler = new Tauler(g.generateKakuro(scanner.nextInt(), scanner.nextInt()));
                    System.out.println("Donam ruta i nom del fitxer:");
                    writer.escriureFitxer(tauler, scanner.next());
                    break;
                case 3:
                    System.out.println("Introdueix Files i Columnes (Més gran que 2)");
                    Tauler tau = new Tauler(g.generateKakuro(scanner.nextInt(), scanner.nextInt()));
                    tau.getSolucio();
                    writer.escriureSolucioConsola(tau);
                    break;
                case 4:
                    Tauler ta = r.llegirConsola();
                    ta.getSolucio();
                    writer.escriureSolucioConsola(ta);
                    break;
                case 5:

                    try {
                        System.out.println("Donam ruta del fitxer: /src/data/exempleX on X es 1,2,3,4 o 5");
                        Tauler b = r.llegirFitxer(scanner.next());
                        b.getSolucio();
                        writer.escriureSolucioConsola(b);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }

        }

    }

}
