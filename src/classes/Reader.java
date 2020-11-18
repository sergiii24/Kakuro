package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    String nom;

    public Reader(String nom) {
        this.nom = nom;
    }

    public Casella[][] llegirFitxer() {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(nom)))) {

            String[] primera_linea;
            primera_linea = br.readLine().split(",");
            int f = Integer.parseInt(primera_linea[0]);
            int c = Integer.parseInt(primera_linea[1]);
            Casella[][] casellas = new Casella[f][c];
            int i = 0;
            String linea;

            while (br.ready()) {

                linea = br.readLine();
                casellas[i] = filaFormat(linea, c);
                i++;

            }

            return casellas;

        } catch (IOException ioException) {
            ioException.printStackTrace();

        }

        return null;
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
                    while (i+1 < linea.length() && Character.isDigit(linea.charAt(i+1))) i++;
                    if (casella[index] == null) casella[index] = new Negre();
                    ((Negre) casella[index]).setFila(Integer.parseInt(linea.substring(inici, i+1)));
                } else if (linea.charAt(i) == 'C') {
                    int inici = i + 1;
                    while (i+1 < linea.length() && Character.isDigit(linea.charAt(i + 1))) i++;
                    if (casella[index] == null) casella[index] = new Negre();
                    ((Negre) casella[index]).setColumna(Integer.parseInt(linea.substring(inici, i+1)));
                }
            }

            i++;

        }

        return casella;
    }

}