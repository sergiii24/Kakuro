package domini;

import dades.CtrlFactoryDades;
import dades.CtrlPersistencia;

public class CtrlDominiGestioUsuari {

	private Usuari usuari;

	public CtrlDominiGestioUsuari() {
		usuari = new Usuari();
	}

	public void logoff() {
		usuari = new Usuari();
	}

	public boolean register(String id, String passwd) {

		CtrlPersistencia ctrlPersistencia = CtrlFactoryDades.getcPersistencia();
		if (ctrlPersistencia.addUser(id, passwd)) {
			usuari = new Registrat(id);
			return true;
		}
		return false;

	}
	
	public boolean login(String id, String passwd) {
		CtrlPersistencia ctrlPersistencia = CtrlFactoryDades.getcPersistencia();
		Registrat usuari = new Registrat();
		if(ctrlPersistencia.login(id, passwd, usuari)) {
			System.out.println(usuari.getPuntuacioTotal());
			this.usuari = usuari;
			return true;
		} return false;
	}
	
	public int baixaUsuari(int idu) {
		//if(!existsUser(idu)) return 1;
		//else {
		//	UsuarisReg.remove(new String(idu));
		//	CtrlDadesUsers.baixaUsuari(idu);
		//}
		return 0;
	}

	public String getId() {
		return usuari.getId();
	}

	public int getNKResolts() {
		return ((Registrat) usuari).getKakuroResolts();
	}

	public int getPuntuacio() {
		return ((Registrat) usuari).getPuntuacioTotal();
	}

	public boolean isRegistrat() {
		return usuari instanceof Registrat;
	}

	public Usuari getUsuari() {
		return usuari;
	}

}
