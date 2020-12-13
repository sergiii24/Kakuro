package domini;

public class Registrat extends Usuari {

	private int puntuacio_total;
	private int kakuro_resolts;
	
	public Registrat() {
		puntuacio_total = 0;
		kakuro_resolts = 0;
	}

	public Registrat(String id) {
		super(id);
		puntuacio_total = 0;
		kakuro_resolts = 0;
	}
	
	public Registrat(String id, int puntuacio_total, int kakuro_resolts) {
		super(id);
		this.puntuacio_total = puntuacio_total;
		this.kakuro_resolts = kakuro_resolts;
	}
	
	public Registrat(Registrat r) {
		this.id = r.id;
		this.puntuacio_total = r.puntuacio_total;
		this.kakuro_resolts = r.kakuro_resolts;
	}
	
	public void setId(String newId) {
		id = newId;
	}
	

	public int getPuntuacioTotal() {
		return puntuacio_total;
	}
	
	public void setPuntuacioTot(int punt) {
		puntuacio_total = punt;
	}
	
	public int getKakuroResolts() {
		return kakuro_resolts;
	}
	
	public void setKakuroResolts(int kak) {
		kakuro_resolts = kak;
	}
	
	@Override
	public boolean isRegistrat() {
		return true;
	}
	

}
