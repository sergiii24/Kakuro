package classes;

import java.util.*;

public class Regles {
	String[] regles;
	
	public Regles() {
		regles = null;
	}
	
	public Regles(String[] regles) {
		this.regles = regles;
	}
	
	public Regles(int n) {
		regles = new String[n];
	}
	
	public String[] getRegles() {
		return regles;
	}
}
