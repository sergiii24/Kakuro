package classes;

public class Mode {
	TipusMode tipus;

	public Mode() {
		tipus = null;
	}
	
	public Mode(TipusMode tipus) {
		this.tipus = tipus;
	}
	
	public void setMode(TipusMode tipus) {
		this.tipus = tipus;
	}
	
	public TipusMode getMode() {
		return tipus;
	}
	
}
