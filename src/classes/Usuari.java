package classes;

public class Usuari {
	private String id;
	private String contrasenya;
	
	public Usuari() {
		id = null;
		contrasenya = null;
	}
	
	public String getId() {
		return id;
	}
	
	public String getContra() {
		return contrasenya;
	}
	
	public void setId(String newId) {
		id = newId;
	}
	
	public void setContra(String newContra) {
		contrasenya = newContra;
	}
	
	public boolean iniciarSessio(String id, String contrasenya) {
		boolean iniciat = false;
		if(id == null || id.isEmpty()) System.out.println("Usuari no vàlid");
		else if(contrasenya == null || contrasenya.isEmpty()) System.out.println("Contrasenya no vàlida");
		else {
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
			/*registrat = CtrlUsuari.registrarUsuari(id, contra1);
			if(registrat) {
				this.id = id;
				contrasenya = contra1;
			}*/
		}
		return registrat;
	}
}
