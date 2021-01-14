package domini;

import java.util.*;

public class Ranquing {
	private Set<PartidaAcabada> ranking;
	
	public Ranquing() {
		ranking = new HashSet<PartidaAcabada>();
	}
	
	public Ranquing(Set<PartidaAcabada> ranking) {
		this.ranking = ranking;
	}
	
	public boolean tePartidaAcabada(PartidaAcabada pa) {
		return ranking.contains(pa);
	}
	
	public int getNPartidaAcabada() {
		return ranking.size();
	}
	
	public void afegirPartidaAcabada(PartidaAcabada pa) {
		if(!tePartidaAcabada(pa)) ranking.add(pa);
	}
	
	public void eliminarPartidaAcabada(PartidaAcabada pa) {
		if(tePartidaAcabada(pa)) ranking.remove(pa);
	}
	
	public PartidaAcabada getPartidaAcabada(String id, Mode mode, Tauler tauler) {
		Iterator<PartidaAcabada> it = ranking.iterator();
		while(it.hasNext()) {
			PartidaAcabada p = it.next();
			if(p.getUser() == id && p.getMode() == mode.getMode() /*&& p.getTauler() == tauler*/) {
				return p;
			}
		}
		return null;
	}
	
	public Set<PartidaAcabada> filtraModeNormal(){
		Iterator<PartidaAcabada> it = ranking.iterator();
		Set<PartidaAcabada> aux = new HashSet<PartidaAcabada>();
		while(it.hasNext()) {
			PartidaAcabada p = it.next();
			if(p.getMode() == TipusMode.NORMAL) {
				aux.add(p);
			}
		}
		return aux;
	}
	
	public Set<PartidaAcabada> filtraModeContra(){
		Iterator<PartidaAcabada> it = ranking.iterator();
		Set<PartidaAcabada> aux = new HashSet<PartidaAcabada>();
		while(it.hasNext()) {
			PartidaAcabada p = it.next();
			if(p.getMode() == TipusMode.CONTRARRELLOTGE) {
				aux.add(p);
			}
		}
		return aux;
	}
}
