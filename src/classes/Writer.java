/*package classes;

import java.io.*;

public class Writer {

    String nom;

    public Reader(String nom) {
        this.nom = nom;
    }

    public void escriureFitxer(Tauler tauler) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(nom)))) {

            bw.write(tauler.getFil()+" "+ tauler.getCol());
            bw.newLine();

            Casella[][] casellas = tauler.getCasellas();

            for (int i = 0; i < casellas.length; i++) {
                for (int j = 0; j < casellas[i].length; j++) {
                    if(casellas[i][j] instanceof Negre) s = s.concat("Negra" + ((Negre)casellas[i][j]).getColumna() + " " + ((Negre)casellas[i][j]).getFila()+"\t" );
                    else s=s.concat("Blanc\t");
                }
                s = s.concat("\n");
            }



        } catch (IOException ioException) {
            ioException.printStackTrace();

        }


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

}*/
