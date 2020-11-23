package domini;

public class PartidaAcabada extends Partida{
	private int puntuacio;
	
	public PartidaAcabada() {
		this.puntuacio = 0;
	}
	
	public PartidaAcabada(Partida p, int puntuacio) {
		super(p.user, p.mode, p.tauler, p.temps);
		this.puntuacio = puntuacio;
	}
	
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	
	public int getPuntuacio() {
		return puntuacio;
	}
}
