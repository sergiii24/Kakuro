package classes;

public class Negre extends Casella {

    int columna, fila;

    public Negre(int columna, int fila) {
        this.columna = columna;
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Negre() {
        columna=0;
        fila=0;
    }
    
    public boolean isNegre() {
    	return this instanceof Negre;
    }
}
