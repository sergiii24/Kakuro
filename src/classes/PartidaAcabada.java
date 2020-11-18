package classes;

public class PartidaAcabada extends Partida{
	private int puntuacio;
	
	public PartidaAcabada() {
		this.puntuacio = 0;
	}
	
	public PartidaAcabada(Partida p, int puntuacio) {
		this.user = p.user;
		this.mode = p.mode;
		this.tauler = p.tauler;
		this.temps = p.temps;
		this.puntuacio = puntuacio;
	}
	
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	
	public int getPuntuacio() {
		return puntuacio;
	}
}
