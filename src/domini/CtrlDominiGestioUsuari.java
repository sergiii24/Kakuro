package domini;

import dades.CtrlDadesUsuari;
import dades.CtrlFactoryDades;
import dades.CtrlPersistencia;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	private Map<String, Integer> sort(Map<String, Integer> m){
		return m.entrySet()
				.stream()
				.sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public List<String> getNameUsersRanking(){
		CtrlDadesUsuari ctrlDadesUsuari = CtrlFactoryDades.getcUsuari();
		Map<String, Integer> aux = sort(ctrlDadesUsuari.getUsuarisRanking());
		List<String> l = new ArrayList<>(aux.keySet());
		return l;
	}

}
