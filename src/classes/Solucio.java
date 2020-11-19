package classes;

public class Solucio {
	private int nsol;
	private Casella[][]solucio;
	
	public Solucio() {
		nsol = 0;
		solucio = null;
	}
			
	public Solucio(int nsol, Casella[][] sol) {
		this.nsol = nsol;
		solucio = sol;
	}
	
	public int getNumSol() {
		return nsol;
	}
	
	public Casella[][] getSolucio() {
		return solucio;
	}

}