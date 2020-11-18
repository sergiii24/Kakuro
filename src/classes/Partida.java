package classes;

public class Partida {
	protected Usuari user;
	protected Mode mode;
	protected Tauler tauler;
	protected int temps;
	
	public Partida() {
		user = null;
		mode = null;
		tauler = null;
		temps = 0;
	}
	
	public Partida(Usuari user, Mode mode, Tauler tauler, int temps) {
		this.user = user;
		this.mode = mode;
		this.tauler = tauler;
		this.temps = temps;
	}
	
	public void setUser(Usuari user) {
		this.user = user;
	}
	
	public Usuari getUser() {
		return user;
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public Mode getMode() {
		return mode;
	}
	
	public void setTauler(Tauler tauler) {
		this.tauler = tauler;
	}
	
	public Tauler getTauler() {
		return tauler;
	}
	
	public void setTemps(int temps) {
		this.temps = temps;
	}
}
