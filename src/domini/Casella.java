package domini;

public abstract class Casella {
	
	private int posx;
	private int posy;
	
	public Casella(){}

	public Casella(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
	}
	
	public int getX() {
		return posx;
	}
	
	public void setX(int x) {
		posx = x;
	}
	
	public int getY() {
		return posy;
	}
	
	public void setY(int y) {
		posy = y;
	}

	public boolean isNegre() {
		return false;
	}
	public boolean isBlanc() {
		return false;
	}
	public boolean isEmpty() {
		return false;
	}

}
