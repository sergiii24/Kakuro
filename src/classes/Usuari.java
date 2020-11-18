package classes;

import java.util.*;

public class Usuari {
	protected String id;
	protected Set<Partida> llista_partides;
	
	
	public Usuari() {
		id = null;
		llista_partides = null;
	}
	
	public Usuari(String id, Set<Partida> llista_partides) {
		this.id = id;
		this.llista_partides = llista_partides;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean tePartides() {
		return llista_partides.isEmpty();
	}
	
	public boolean contePartida(Partida p) {
		return llista_partides.contains(p);
	}
	
	public int getNPartides() {
		return llista_partides.size();
	}
	
	public Set<Partida> getPartides() {
		return llista_partides;
	}
	
	public void afegirPartides(Partida p) {
		llista_partides.add(p);
	}
	
	public void borrarPartida(Partida p) {
		if(contePartida(p)) {
			llista_partides.remove(p);
		}
	}
	
	public boolean isRegistrat() {
		return false;
	}
	
}
