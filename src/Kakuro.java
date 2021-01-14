import dades.Reader;
import dades.Writer;
import domini.Casella;
import domini.CtrlFactoryDomini;
import domini.Generador;
import domini.Tauler;
import domini.algorismes.MonteState;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kakuro {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Reader r = new Reader();
        Generador g = new Generador();
        Writer writer = new Writer();


        try {

            Tauler b = new Reader().llegirFitxer("src/data/students24x14.txt");
            b.updatePossibilities();

            //b.getSolucio();


            Casella[][] nou = b.clonar();

            MonteState state = new MonteState(nou);

           /* final int level = 2;
            final long maxRunningTimeMs = 2 * 60 * 1000;
            final long endTimeMs = System.currentTimeMillis() + maxRunningTimeMs;
            long time = System.currentTimeMillis();
            final Pair<Double, List<Pair<Position, Integer>>> result = new NestedMonteCarloSearch().executeSearch(state, level, () -> {
                return System.currentTimeMillis() > endTimeMs;
            });
            System.out.println("Forward: "+(System.currentTimeMillis()-time));

            System.out.println(result.item1);
            for ( Pair<Position, Integer> p : result.item2) {
                ((Blanc)b.getCasellas()[p.item1.i][p.item1.j]).setNum(p.item2);
            }
*/
            //b.getSolucio();

            JPanel panel = CtrlFactoryDomini.getcDTaulellInstance().getBoardUI(new Tauler(b.getSolucio()));
            JFrame frame = new JFrame();
            frame.setTitle("My First Swing Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel label = new JLabel("Welcome");
            frame.add(panel);
            frame.pack();
            frame.setVisible(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
/*


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
                    Tauler t = new Tauler(g.generateKakuro(scanner.nextInt(), scanner.nextInt(), TipusDificultat.NORMAL));
                    writer.escriureConsola(t);
                    break;
                case 2:
                    System.out.println("Introdueix Files i Columnes (Més gran que 2)");
                    Tauler tauler = new Tauler(g.generateKakuro(scanner.nextInt(), scanner.nextInt(), TipusDificultat.NORMAL));
                    System.out.println("Donam ruta i nom del fitxer:");
                    writer.escriureFitxer(tauler, scanner.next());
                    break;
                case 3:
                    System.out.println("Introdueix Files i Columnes (Més gran que 2)");
                    Tauler tau = new Tauler(g.generateKakuro(scanner.nextInt(), scanner.nextInt(), TipusDificultat.NORMAL));
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
*/

    }

}
