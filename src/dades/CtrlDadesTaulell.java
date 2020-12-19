package dades;

import domini.Blanc;
import domini.Casella;
import domini.Negre;
import domini.Tauler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CtrlDadesTaulell {

    public Tauler getPublicKakuro(String nom) {

        try {
            return llegir(new FileReader("data/kakuro/" + nom));
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
        return null;
    }

    public Tauler getUserKakuro(String user, String nom) {

        try {
            return llegir(new FileReader("data/users/" + user + "/kakuros/" + nom));
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
        return null;
    }


    private Tauler llegir(InputStreamReader input) {

        Tauler t = null;
        try (BufferedReader br = new BufferedReader(input)) {

            String[] primera_linea;
            primera_linea = br.readLine().split(",");
            int f = Integer.parseInt(primera_linea[0]);
            int c = Integer.parseInt(primera_linea[1]);
            if (f < 2 || c < 2) throw new Exception("Tamany invalid, no es permet files o columnes més petites que 2");
            Casella[][] casellas = new Casella[f][c];

            int i = 0, j = 0;

            String linea = "";

            while (br.ready()) {

                linea = br.readLine();
                casellas[i] = filaFormat(linea, c);
                i++;

            }

            t = new Tauler(casellas);

            return t;

        } catch (IOException ioException) {
            ioException.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;

    }

    private Casella[] filaFormat(String linea, int c) {

        int i = 0;
        Casella[] casella = new Casella[c];
        int index = 0;

        while (i < linea.length()) {

            if (linea.charAt(i) == '?') {
                casella[index] = new Blanc();
            } else if (linea.charAt(i) == '*') {
                casella[index] = new Negre();
            } else if (linea.charAt(i) == ',') {
                index++;
            } else {
                if (linea.charAt(i) == 'F') {
                    int inici = i + 1;
                    while (i + 1 < linea.length() && Character.isDigit(linea.charAt(i + 1))) i++;
                    if (casella[index] == null) casella[index] = new Negre();
                    ((Negre) casella[index]).setFila(Integer.parseInt(linea.substring(inici, i + 1)));
                } else if (linea.charAt(i) == 'C') {
                    int inici = i + 1;
                    while (i + 1 < linea.length() && Character.isDigit(linea.charAt(i + 1))) i++;
                    if (casella[index] == null) casella[index] = new Negre();
                    ((Negre) casella[index]).setColumna(Integer.parseInt(linea.substring(inici, i + 1)));
                }
            }

            i++;

        }

        return casella;
    }


    public void importar(File selectedFile, String id) {

        try {
            Files.copy(selectedFile.toPath(), Paths.get("data/users/" + id + "/kakuros/" + selectedFile.getName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveBoard(Tauler t, String id) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/users/" + id + "/kakuros/" + t.getId()))) {

            bw.write(t.toString());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public void escriureFitxer(Tauler tauler, String nom) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nom))) {

            bw.write(tauler.toString());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }


}
