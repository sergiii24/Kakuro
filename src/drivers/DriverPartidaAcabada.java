package drivers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import domini.*;

public class DriverPartidaAcabada {

	public static void opcions() {
		System.out.println("Tria una opci� (n�mero) seguit dels par�metres necessaris per comprovar el m�tode:");
        System.out.println("\t 1) PartidaAcabada()");
        System.out.println("\t 2) Partida(Partida, punts), Param -> 1 nom, 2 nums.");
        System.out.println("\t 3) setPuntuacio(punts), Param -> 1 num.");
        System.out.println("\t 4) getPuntuacio().");
	}
	
	public static void main(String[] args) {
		String classe = "Partida";
		System.out.println("Driver " + classe + ":");
		
		PartidaAcabada P = new PartidaAcabada();
		
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
							P = new PartidaAcabada();
							break;
						case "2":
							P = new PartidaAcabada(new Partida(param[1], TipusMode.NORMAL, new Tauler(), Integer.parseInt(param[2])), Integer.parseInt(param[3]));
							break;
						case "3":
							P.setPuntuacio(Integer.parseInt(param[1]));
							break;
						case "4":
							System.out.println(P.getPuntuacio());
							break;
						default:
							System.out.println("Proba una altre opci�");
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
