package drivers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import domini.*;
import java.util.*;

public class DriverRanquing {

	public static void opcions() {
		System.out.println("Tria una opci� (n�mero) seguit dels par�metres necessaris per comprovar el m�tode:");
        System.out.println("\t 1) Ranquing()");
        System.out.println("\t 2) Ranquing(s)");
        System.out.println("\t 3) getNPartidaAcabada()");
        System.out.println("\t 4) afegirPartidaAcabada()");
        System.out.println("\t 5) eliminarPartidaAcabada()");
        System.out.println("\t 6) getPartidaAcabada(User, Mode, Tauler)");
        System.out.println("\t 7) filtraModeNormal()");
        System.out.println("\t 8) filtraModeContra()");
	}
	
	public static void main(String[] args) {
		String classe = "Ranquing";
		System.out.println("Driver " + classe + ":");
		
		Ranquing R = new Ranquing();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			boolean acabar = false;
			while(!acabar) {
				opcions();
				
				String line;
				String param[];
				String op;
				
				line = br.readLine();
				param = line.split(" ");
				op = param[0];
				try {
					switch(op) {
						case "0":
							acabar = true;
							break;
						case "1":
							R = new Ranquing();
							break;
						case "2":
							Set<PartidaAcabada> s = new HashSet<PartidaAcabada>();
							R = new Ranquing(s);
							break;
						case "3":
							System.out.println(R.getNPartidaAcabada());
							break;
						case "4":
							PartidaAcabada pa = new PartidaAcabada();
							System.out.println(R.getNPartidaAcabada());
							R.afegirPartidaAcabada(pa);
							System.out.println(R.getNPartidaAcabada());
							break;
						case "5":
							PartidaAcabada pa1 = new PartidaAcabada();
							R.afegirPartidaAcabada(pa1);
							System.out.println(R.getNPartidaAcabada());
							R.eliminarPartidaAcabada(pa1);
							System.out.println(R.getNPartidaAcabada());
							break;
						case "6":
							PartidaAcabada pa5 = new PartidaAcabada();
							pa5.setUser("Pere");
							pa5.setMode(TipusMode.NORMAL);
							pa5.setTauler(new Tauler());
							pa5.setTemps(10);
							pa5.setPuntuacio(10);
							R.afegirPartidaAcabada(pa5);
							PartidaAcabada pa2 = R.getPartidaAcabada("Pere", new Mode(TipusMode.NORMAL), new Tauler());
							System.out.println(pa2.getUser());
							System.out.println(pa2.getMode());
							break;
						case "7":
							int N = Integer.parseInt(param[1]);
							for(int i = 0; i < N; ++i) {
								PartidaAcabada pa22 = new PartidaAcabada();
								pa22.setMode(TipusMode.NORMAL);
								R.afegirPartidaAcabada(pa22);
							}
							Set<PartidaAcabada> sm = R.filtraModeNormal();
							System.out.println(sm.size());
							break;
						case "8":
							int N1 = Integer.parseInt(param[1]);
							for(int i = 0; i < N1; ++i) {
								PartidaAcabada pa21 = new PartidaAcabada();
								pa21.setMode((TipusMode.CONTRARRELLOTGE));
								R.afegirPartidaAcabada(pa21);
							}
							Set<PartidaAcabada> sm1 = R.filtraModeContra();
							System.out.println(sm1.size());
							break;
						default:
							System.out.println("Tria una altre opci� crack.");
							break;
					}
				
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
