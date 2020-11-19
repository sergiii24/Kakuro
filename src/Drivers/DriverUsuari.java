package Drivers;

import classes.*;
import java.io.*;
import java.util.*;

public class DriverUsuari {
	
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
		String classe = "Usuari";
		System.out.println("Driver " + classe + ":");
		
		Usuari U = new Usuari();
		
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
					switch (op) {
						case"0": 
							acabar = true;
							break;
						case"1":
							U = new Usuari();
							System.out.println("Creadora seleccionada.");
						break;
						case"2":
							String id = param[1];
							U = new Usuari(id);
							System.out.println("Creadora 2 seleccionada.");
						break;
						case"3":
							Set<Partida> partides = null;
							String id1211 = param[1];
							U = new Usuari(id1211, partides);
							System.out.println("Creadora 3 seleccionada.");
						break;
						case"4":
							String id11 = param[1];
							U = new Usuari(id11);
							System.out.println(U.getId());
							System.out.println("getId().");
							break;
						case"5":
							String id111 = param[1];
							String id2 = param[2];
							String id3 = param[3];
							U = new Usuari(id111);
							Usuari aux = new Usuari(id2);
							System.out.println(U.equals(aux));
							aux = new Usuari(id3);
							System.out.println(U.equals(aux));
							System.out.println("equals(Usuari).");
							break;
						case"6": 
							String id7 = param[1];
							Partida p = new Partida("Joan");
							Set<Partida> partides1 = new HashSet<Partida>();
							partides1.add(p);
							U = new Usuari(id7, partides1);
							System.out.println(U.tePartides());
							partides1.remove(p);
							U = new Usuari(id7, partides1);
							System.out.println(U.tePartides());
							System.out.println("tePartides().");
							break;
						case"7":
							String id15 = param[1];
							Partida p1 = new Partida();
							Set<Partida> partides11 = new HashSet<Partida>();
							partides11.add(p1);
							U = new Usuari(id15, partides11);
							System.out.println(U.contePartida(p1));
							partides11.remove(p1);
							U = new Usuari(id15, partides11);
							System.out.println(U.contePartida(p1));
							System.out.println("contePartida");
							break;
						case"8":
							String id5 = param[1];
							Partida p5 = new Partida();
							Partida p11 = new Partida();
							Set<Partida> partides12 = new HashSet<Partida>();
							partides12.add(p5);
							partides12.add(p11);
							U = new Usuari(id5, partides12);
							System.out.println(U.getNPartides());
							System.out.println("getNPartides");
							break;
						case"9":
							Set<Partida> nPartides = new HashSet<Partida>();
							nPartides = U.getPartides();
							System.out.println("getPartides");
							break;
						case"10":
							Partida p2 = new Partida();
							Partida p3 = new Partida();
							System.out.println(U.getNPartides());
							U.afegirPartides(p2);
							System.out.println(U.getNPartides());
							U.afegirPartides(p3);
							System.out.println(U.getNPartides());
							System.out.println("afegirPartides");
							break;
						case "11": 
							Partida p4 = new Partida();
							U.afegirPartides(p4);
							System.out.println("borrarPartida");
							U.borrarPartida(p4);
							U.borrarPartida(p4);
							System.out.println("borrarPartida");
							break;
						case "12":
							System.out.println(U.isRegistrat());
							System.out.println("isRegistrat");
							break;
						case "13":
							System.out.println(U.getNPartides());
							U.buidarPartides();
							System.out.println(U.getNPartides());
						default: 
							System.out.println("Tria un altre nombre crack");
							break;
					}
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
