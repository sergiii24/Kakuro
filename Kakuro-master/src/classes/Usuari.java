package classes;

import java.util.*;

public class Usuari {
	protected String id;
	protected Set<Partida> llista_partides;
	
	
	public Usuari() {
		id = null;
		llista_partides = new HashSet<Partida>();
	}
	
	public Usuari(String id) {
		this.id = id;
		llista_partides = new HashSet<Partida>();
	}
	
	public Usuari(String id, Set<Partida> llista_partides) {
		this.id = id;
		this.llista_partides = llista_partides;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean equals(Usuari user) {
		if(this.id.equals(user.getId())) return true;
		else return false;
	}
	
	public boolean tePartides() {
		return !llista_partides.isEmpty();
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
	
	public void buidarPartides() {
		llista_partides.clear();
	}
	
	public void afegirPartides(Partida p) {
		if(!contePartida(p)) llista_partides.add(p);
		else System.out.println("Malament");
	}
	
	public void borrarPartida(Partida p) {
		if(contePartida(p)) {
			llista_partides.remove(p);
			System.out.println("Borrat");
		}
		System.out.println("No hi era.");
	}
	
	public boolean isRegistrat() {
		return false;
	}
	
}
