package Drivers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import classes.*;

public class DriverMode {

	public static void opcions() {
		System.out.println("Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
        System.out.println("\t 1) Mode()");
        System.out.println("\t 2) Mode(NORMAL)");
        System.out.println("\t 3) Mode(CONTRARRELOTGE)");
        System.out.println("\t 4) setMode(NORMAL)");
        System.out.println("\t 5) getMode(NORMAL)");
        System.out.println("\t 4) setMode(CONTRARRELOTGE)");
        System.out.println("\t 5) getMode(CONTRARRELOTGE)");
	}
	
	public static void main(String[] args) {
		String classe = "Registrat";
		System.out.println("Driver " + classe + ":");
		
		Mode M = new Mode();
		
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
							M = new Mode();
							System.out.println(M.getMode());
							break;
						case "2":
							M = new Mode(TipusMode.NORMAL);
							System.out.println(M.getMode());
							break;
						case "3":
							M = new Mode(TipusMode.CONTRARRELLOTGE);
							System.out.println(M.getMode());
							break;
						case "4":
							M.setMode(TipusMode.NORMAL);
							break;
						case "5":
							TipusMode t = M.getMode();
							System.out.println(t);
							break;
						case "6":
							M.setMode(TipusMode.CONTRARRELLOTGE);
							break;
						case "7":
							TipusMode t1 = M.getMode();
							System.out.println(t1);
							break;
						default:
							System.out.println("Tria una altre opció");
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
