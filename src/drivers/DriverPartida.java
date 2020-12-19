package drivers;

import domini.Mode;
import domini.Partida;
import domini.Tauler;
import domini.TipusMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverPartida {

	public static void opcions() {
		System.out.println("Tria una opci� (n�mero) seguit dels par�metres necessaris per comprovar el m�tode:");
        System.out.println("\t 1) Partida()");
        System.out.println("\t 2) Partida(user), Param -> 1 nom.");
        System.out.println("\t 3) Partida(user, mode, tauler, temps), Param -> 1 nom, 1 numero");
        System.out.println("\t 4) setUser(), Param -> 1 nom.");
        System.out.println("\t 5) getUser()");
        System.out.println("\t 6) setMode(), Param -> 1 TipusMode(NORMAL o CONTRA).");
        System.out.println("\t 7) getMode()");
        System.out.println("\t 8) setTauler(), Param -> 1 num.");
        System.out.println("\t 9) getTauler()");
        System.out.println("\t 4) setTemps(), Param -> 1 num.");
        System.out.println("\t 5) getTemps()");
	}
	
	public static void main(String[] args) {
		String classe = "Partida";
		System.out.println("Driver " + classe + ":");
		
		Partida P = new Partida();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			boolean acabar = false;
			while(!acabar) {
				opcions();

				String line;
				String[] param;
				String op;

				line = br.readLine();
				param = line.split(" ");
				op = param[0];
				try {
					switch (op) {
						case "0":
							acabar = true;
							break;
						case "1":
							P = new Partida();
							break;
						case "2":
							P = new Partida(param[1]);
							break;
						case "3":
							P = new Partida(param[1], new Mode(), new Tauler(), Integer.parseInt(param[2]));
							break;
						case "4":
							P.setUser(param[1]);
							break;
						case "5":
							String s = P.getUser();
							System.out.println(s);
							break;
						case "6":
							if (param[1].equals("NORMAL")) P.setMode(new Mode(TipusMode.NORMAL));
							else if (param[1].equals("CONTRA")) P.setMode(new Mode(TipusMode.CONTRARRELLOTGE));
							else System.out.println("Has de triar entre NORMAL o CONTRA");
							break;
						case "7":
							Mode m = P.getMode();
							System.out.println(m.getMode());
							break;
						case "8":
							Tauler t1 = new Tauler();
							t1.setId(param[1]);
							P.setTauler(t1);
							break;
						case "9":
							Tauler t = P.getTauler();
							System.out.println(t.getId());
							break;
						case "10":
							P.setTemps(Integer.parseInt(param[1]));
							break;
						case "11":
							System.out.println(P.getTemps());
							break;
						default:
							System.out.println("Tira una altre opci� crack");
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
