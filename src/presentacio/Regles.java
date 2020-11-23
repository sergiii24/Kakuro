package presentacio;

import java.util.*;

public class Regles {
	String[] regles = { "S'ha de posar a cada casella blanca un nombre del 1 al 9.",
						"La suma en horitzontal de cada casella blanca ha de coincidir amb el nombre superior de la casella negre.",
						"La suma en vertical de cada casella blanca ha de coincidir amb el nombre inferior de la casella negre.",
						"No es pot posar el mateix nombre en una fila o en una columna."};
	
	public Regles() {
		
	}
	
	public Regles(String[] regles) {
		this.regles = regles;
	}
	
	public int getNRegles() {
		return regles.length;
	}
	
	public String getRegla(int i){
		return regles[i];
	}
	
	public String[] getRegles() {
		return regles;
	}
}
