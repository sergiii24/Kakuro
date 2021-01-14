package domini;

import java.io.Serializable;

public class Partida implements Serializable {
	protected String user;
	protected TipusMode mode;
	protected Tauler tauler;
	protected int temps;
	protected Usuari usuari;

	public Partida() {
		user = null;
		mode = null;
		tauler = null;
		temps = 0;
	}

	public Partida(String user) {
		this.user = user;
		mode = null;
		tauler = null;
		temps = 0;
	}

	public Partida(Usuari usuari, TipusMode mode, Tauler tauler) {
		this.usuari = usuari;
		this.mode = mode;
		this.tauler = tauler;
		this.temps = temps;
	}

	public Partida(String user, TipusMode mode, Tauler tauler, int temps) {
		this.user = user;
		this.mode = mode;
		this.tauler = tauler;
		this.temps = temps;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setMode(TipusMode mode) {
		this.mode = mode;
	}
	
	public TipusMode getMode() {
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
	
	public int getTemps() {
		return this.temps;
	}

	public Usuari getUsuari() {return usuari; }

}
