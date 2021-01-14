package presentacio;

import java.util.*;

public class Regles {
	String[] regles = { "You must fill in the blank white boxes with a number between 1 and 9.",
			"The horizontal sum of each group of white boxes must match the left number of the black box they have on their left.",
			"The vertical sum of each group of white boxes must match the bottom number of the black box they have above.",
			"You cannot repeat a number in a group of white boxes (neither horizontally nor vertically).",
			"Fill in all the white boxes to win!"};
	
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
