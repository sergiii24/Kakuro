package classes;

import java.util.*;

public class Ranquing {
	private Set<PartidaAcabada> ranking;
	
	public Ranquing() {
		ranking = null;
	}
	
	public Ranquing(Set<PartidaAcabada> ranking) {
		this.ranking = ranking;
	}
	
	public void afegirPartidaAcabada(PartidaAcabada pa) {
		ranking.add(pa);
	}
	
	public PartidaAcabada getPartidaAcabada(Usuari user, Mode mode, Tauler tauler) {
		Iterator<PartidaAcabada> it = ranking.iterator();
		while(it.hasNext()) {
			PartidaAcabada p = it.next();
			if(p.getUser() == user.id && p.getMode() == mode && p.getTauler() == tauler) {
				return p;
			}
		}
		return null;
	}
	
	public Set<PartidaAcabada> filtraModeNormal(){
		Iterator<PartidaAcabada> it = ranking.iterator();
		Set<PartidaAcabada> aux = null;
		while(it.hasNext()) {
			PartidaAcabada p = it.next();
			if(p.getMode().tipus == TipusMode.NORMAL) {
				aux.add(p);
			}
		}
		return aux;
	}
	
	public Set<PartidaAcabada> filtraModeContra(){
		Iterator<PartidaAcabada> it = ranking.iterator();
		Set<PartidaAcabada> aux = null;
		while(it.hasNext()) {
			PartidaAcabada p = it.next();
			if(p.getMode().tipus == TipusMode.CONTRARRELLOTGE) {
				aux.add(p);
			}
		}
		return aux;
	}
}
