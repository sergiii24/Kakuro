package classes;

public abstract class Casella {

	public boolean isNegre() {
		return this instanceof Negre;
	}
	public boolean isBlanc() {
		return this instanceof Blanc;
	}

	public boolean isEmpty() {
		return false;
	}

	public boolean isValid() {
		return false;
	}
}
