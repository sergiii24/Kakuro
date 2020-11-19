package Drivers;

import classes.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import classes.Usuari;

public class DriverRegles {
	
	public static void opcions() {
		System.out.println("Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
        System.out.println("\t 1) Usuari()");
        System.out.println("\t 2) Usuari(String id), Param -> 1 id.");
        System.out.println("\t 3) Usuari(String id, Set<Partida> llista_partides), Param -> 1 id.");
        System.out.println("\t 4) String getId(), Param -> 1 id.");
        System.out.println("\t 5) boolean equals(Usuari user), Param -> 3 id.");
        System.out.println("\t 6) boolean tePartides(), Param -> 1 id.");
        System.out.println("\t 7) boolean contePartida, Param -> 1 id.");
        System.out.println("\t 8) int getNPartides(), Param -> 1 id.");
        System.out.println("\t 9) Set<Partida> getPartides()");
        System.out.println("\t 10) void afegirPartida(Partida p)");
        System.out.println("\t 11) void borrarPartida(Partida p)");
        System.out.println("\t 12) boolean isRegistrat()");
        System.out.println("\t 13) void borrarPartides()");
	}
	
	public static void main(String[] args) {
		String classe = "Regles";
		System.out.println("Driver " + classe + ":");
		
		Regles R = new Regles();
		
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
					System.out.println("You have selected this option: " + op);
					switch(op) {
						case "0":
							acabar = true;
							break;
						case "1":
							R = new Regles();
							break;
						case "2":
							String[] s = {"S'ha de posar a cada casella blanca un nombre del 1 al 9.",
							"La suma en horitzontal de cada casella blanca ha de coincidir amb el nombre superior de la casella negre.",
							"La suma en vertical de cada casella blanca ha de coincidir amb el nombre inferior de la casella negre.",
							"No es pot posar el mateix nombre en una fila o en una columna."};
							R = new Regles(s);
							for(int i = 0; i < s.length; ++i) System.out.println(s[i]);
							break;
						case "3":
							int n = R.getNRegles();
							System.out.println(n);
							break;
						case "4":
							String[] s1 = R.getRegles();
							for(int i = 0; i < s1.length; ++i) System.out.println(s1[i]);
							break;
						case "5":
							for(int i = 0; i < R.getNRegles(); ++i) System.out.println(R.getRegla(i));
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
