package classes;

import java.util.Arrays;

public class Tauler {

    private Casella[][] casellas;
    private int col;
    private int fil;

    public Tauler(Casella[][] casellas) {
        this.casellas = casellas;
        col = casellas[0].length;
        fil = casellas.length;
    }

    public Casella[][] getCasellas() {
        return casellas;
    }

    public int getCol() {
        return col;
    }

    public int getFil() {
        return fil;
    }

    public Tauler(int f, int c) {
        this.casellas = new Casella[f][c];
    }

    @Override
    public String toString() {

        String s = "";

        for (int i = 0; i < casellas.length; i++) {
            for (int j = 0; j < casellas[i].length; j++) {
                if(casellas[i][j] instanceof Negre) {
                	if(((Negre) casellas[i][j]).getColumna() != 0 && ((Negre) casellas[i][j]).getFila() != 0) {
                		s = s.concat("C" + ((Negre)casellas[i][j]).getColumna() + "F" + ((Negre)casellas[i][j]).getFila()+"\t" );
                	}
                	else if(((Negre)casellas[i][j]).getColumna() != 0) {
                		s = s.concat("C" + ((Negre)casellas[i][j]).getColumna() + "\t");
                	}
                	else if(((Negre)casellas[i][j]).getFila() != 0) {
                		s = s.concat("F" + ((Negre)casellas[i][j]).getFila() + "\t");
                	}
                	else {
                		s = s.concat("*\t");
                	}
                }
                else {
                	if(((Blanc)casellas[i][j]).getNum() == 0) s = s.concat("?\t");
                	else s = s.concat(((Blanc)casellas[i][j]).getNum() + "\t");
                }
            }
        s = s.concat("\n");
        }

        return "Tauler casellas=\n" + s;
    }
}
