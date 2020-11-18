package classes;

public class Registrat extends Usuari {
	private String contrasenya;
	private int puntuacio_total;
	private int kakuro_resolts;
	
	public Registrat() {
		contrasenya = null;
		puntuacio_total = 0;
		kakuro_resolts = 0;
	}
	
	public Registrat(String id, String contrasenya) {
		this.id = id;
		this.contrasenya = contrasenya;
		puntuacio_total = 0;
		kakuro_resolts = 0;
	}
	
	public void setId(String newId) {
		id = newId;
	}
	
	public String getContra() {
		return contrasenya;
	}
	
	public void setContra(String newContra) {
		contrasenya = newContra;
	}
	
	public void setPuntuacioTot(int punt) {
		puntuacio_total = punt;
	}
	
	public int getPuntuacioTotal() {
		return puntuacio_total;
	}
	
	public void setKakuroResolts(int kak) {
		kakuro_resolts = kak;
	}
	
	public int getKakuroResolts() {
		return kakuro_resolts;
	}
	
	@Override
	public boolean isRegistrat() {
		return true;
	}
	
	public boolean iniciarSessio(String id, String contrasenya) {
		boolean iniciat = false;
		if(id == null || id.isEmpty()) System.out.println("Usuari no vàlid");
		else if(contrasenya == null || contrasenya.isEmpty()) System.out.println("Contrasenya no vàlida");
		else {
			this.id = id;
			this.contrasenya = contrasenya;
			iniciat = true;
			/*iniciat = CtrlUsuari.iniciarSessio(id, contrasenya);
			if(iniciat){
				this.id = id;
				this.contrasenya = contrasenya;
			}*/
		}
		return iniciat;
	}
	
	public boolean registrarUsuari(String id, String contra1, String contra2) {
		boolean registrat = false;
		if(id == null || id.isEmpty()) System.out.println("Usuari no vàlid");
		else if(contra1 == null || contra1.isEmpty() || contra2 == null || contra2.isEmpty()) System.out.println("Contrasenya no vàlida");
		else if (!contra1.equals(contra2)) System.out.println("Les contrasenyes no coincideixen");
		else {
			this.id = id;
			this.contrasenya = contra1;
			registrat = true;
			/*registrat = CtrlUsuari.registrarUsuari(id, contra1);
			if(registrat) {
				this.id = id;
				contrasenya = contra1;
			}*/
		}
		return registrat;
	}
}
