package classes;

import java.util.Arrays;

public class Tauler {

    private Casella[][] casellas;
    private Casella[][] solucio;
    private int nsol;
    private int col;
    private int fil;
    private TipusDificultat dificultat; //encara no creada
    private boolean acabat;
    private boolean publi;
    

    public Tauler() {
    	casellas = null;
    	solucio = null;
    }
    
    public Tauler(Casella[][] casellas) {
    	this.casellas = casellas;
    	solucio = null;
    }
    
    public Tauler(Casella[][] casellas, TipusDificultat dificultat, boolean acabat, boolean publi) {
        this.casellas = casellas;
        solucio = null;
        col = casellas[0].length;
        fil = casellas.length;
        this.dificultat = dificultat;
        this.acabat = acabat;
        this.publi = publi; 
    }

    public Casella[][] getCasellas() {
        return casellas;
    }

    public Casella[][] getSolucio() {
    	if(solucio == null) {
    		Tauler t = new Tauler(casellas, dificultat, acabat, publi);
    		Solver s = new Solver();
    		Solucio sol = s.solve(t);
    		if(sol == null) System.out.println("No hi ha solució");
    		else {
    			nsol = sol.getNumSol();
    			solucio = sol.getSolucio();
    		}
    	}
        return solucio;
    }
    
    public int getNumSol() {
    	if(solucio == null) {
    		Tauler t = new Tauler(casellas, dificultat, acabat, publi);
    		Solver s = new Solver();
    		Solucio sol = s.solve(t);
    		if(sol == null) System.out.println("No hi ha solució");
    		else {
    			nsol = sol.getNumSol();
    			solucio = sol.getSolucio();
    		}
    	}
        return nsol;
    }
    
    public int getCol() {
        return col;
    }

    public int getFil() {
        return fil;
    }
    
    public TipusDificultat getDificultat() {
    	return dificultat;
    }
    
    public boolean isAcabat() {
    	return acabat;
    }
    
    public boolean isPublic() {
    	return publi;
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
