package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public Reader() {
	}

	String nom;

    public Reader(String nom) {
        this.nom = nom;
    }

    public Tauler llegirFitxer() {
    	Tauler t = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
    	
            String linea = br.readLine();
            int f = Character.getNumericValue(linea.charAt(0));
            int c = Character.getNumericValue(linea.charAt(2));

            //System.out.println(f + " " + c);

            Casella[][] casellas = new Casella[f][c];

            int i = 0, j = 0;

            while (br.ready()) {

                linea = br.readLine();
                casellas[i] = filaFormat(linea, c);
                i++;

            }

            t = new Tauler(casellas);
            /*System.out.println(t.toString());
            Solver s = new Solver();
            s.solve(t);*/
            return t;

        } catch (IOException ioException) {
            ioException.printStackTrace();

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