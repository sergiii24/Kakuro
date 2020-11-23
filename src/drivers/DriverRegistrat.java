package drivers;

import domini.*;
import java.io.*;

public class DriverRegistrat {

	public static void opcions() {
		System.out.println("Tria una opci� (n�mero) seguit dels par�metres necessaris per comprovar el m�tode:");
        System.out.println("\t 1) Registrat()");
        System.out.println("\t 2) Registrat(String id, String contrasenya), Param -> 1 id, 1 contra.");
        System.out.println("\t 3) Registrat(String id, String contrasenya, int puntuacio_total, int kakuro_resolts), Param -> 1 id, 1 contra, 1 punts, 1 kakuro.");
        System.out.println("\t 4) Registrat(Registrat r), Param -> 1 id, 1 contra, 1 punts, 1 kakuro.");
        System.out.println("\t 5) void setId(String newId), Param -> 1 id.");
        System.out.println("\t 6) String getContra()");
        System.out.println("\t 7) void setContra(String newContra), Param -> 1 contra.");
        System.out.println("\t 8) int getPuntuacioTotal()");
        System.out.println("\t 9) void setPuntuacioTotal(int punt), Param -> 1 punts.");
        System.out.println("\t 10) int getKakuroResolts()");
        System.out.println("\t 11) void setKakuroResolts(int kak), Param -> 1 kakuros.");
        System.out.println("\t 12) boolean isRegistrat()");
        System.out.println("\t 13) void iniciarSessio(String id, String contra), Param -> 1 id, 1 contra.");
        System.out.println("\t 14) void registrarUsuari(String id, String contra1, String contra2), Param -> 1 id, 2 contra.");
	}
	
	public static void main(String[] args) {
		String classe = "Registrat";
		System.out.println("Driver " + classe + ":");
		
		Registrat R = new Registrat();
		
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
						case"0": 
							acabar = true;
							break;
						case "1":
							R = new Registrat();
							break;
						case "2":
							String id = param[1];
							String contra = param[2];
							R = new Registrat(id, contra);
							break;
						case "3":
							String id1 = param[1];
							String contra1 = param[2];
							int punts = Integer.parseInt(param[3]);
							int kakuros = Integer.parseInt(param[4]);
							R = new Registrat(id1, contra1, punts, kakuros);
							break;
						case "4":
							String id2 = param[1];
							String contra2 = param[2];
							int punts2 = Integer.parseInt(param[3]);
							int kakuros2 = Integer.parseInt(param[4]);
							R = new Registrat(new Registrat(id2, contra2, punts2, kakuros2));
							break;
						case "5":
							String id3 = param[1];
							R.setId(id3);
							break;
						case "6":
							String s = R.getContra();
							System.out.println(s);
							break;
						case "7":
							String contra3 = param[1];
							R.setContra(contra3);
							break;
						case "8":
							int p = R.getPuntuacioTotal();
							System.out.println(p);
							break;
						case "9":
							int punts3 = Integer.parseInt(param[1]);
							R.setPuntuacioTot(punts3);
							break;
						case "10":
							int p2 = R.getKakuroResolts();
							System.out.println(p2);
							break;
						case "11":
							int kakuros3 = Integer.parseInt(param[2]);
							R.setKakuroResolts(kakuros3);
							break;
						case "12":
							System.out.println(R.isRegistrat());
							break;
						case "13":
							String id4 = param[1];
							String contra4 = param[2];
							R.iniciarSessio(id4, contra4);
							break;
						case "14":
							String id5 = param[1];
							String contra5 = param[2];
							String contra6 = param[3];
							R.registrarUsuari(id5, contra5, contra6);
							break;
						default:
							System.out.println("Torna a probar.");
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
