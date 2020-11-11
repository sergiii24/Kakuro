package classes;

public abstract class Casella {

	public boolean isNegre() {
		return this instanceof Negre;
	}
	public boolean isBlanc() {
		return this instanceof Blanc;
	}
	
}
