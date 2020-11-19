package Drivers;

import classes.*;
import java.io.*;
import java.util.*;

public class DriverCasellesBN {

	public static void opcions() {
		System.out.println("Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
        System.out.println("\t 1) Negre() i Blanc()");
        System.out.println("\t 2) Blanc(num), Param -> 1 num.");
        System.out.println("\t 3) Negre(fil, col), Param -> 2 nums.");
        System.out.println("\t 4) Blanc -> int getNum()");
        System.out.println("\t 5) Blanc -> void setNum(num), Param -> 1 num.");
        System.out.println("\t 6) Blanc -> boolean isBlanc()");
        System.out.println("\t 7) Blanc -> boolean isNegre()");
        System.out.println("\t 8) Negre -> int getColumna()");
        System.out.println("\t 9) Negre -> void setColumna(col), Param -> 1 num.");
        System.out.println("\t 10) Negre -> int getFila()");
        System.out.println("\t 11) Negre -> void setFila(fil), Param -> 1 num.");
        System.out.println("\t 12) Negre -> boolean isBlanc()");
        System.out.println("\t 13) Negre -> boolean isNegre()");
        System.out.println("\t 14) Blanc i Negre -> setX(), setY() I getX() i getY(), Param -> 4 num.");
        
	}
	
	public static void main(String[] args) {
		String classe = "Casella";
		System.out.println("Driver " + classe + ":");
		
		Negre N = new Negre();
		Blanc B = new Blanc();
		
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
							B = new Blanc();
							N = new Negre();
							break;
						case "2":
							int num = Integer.parseInt(param[1]);
							B = new Blanc(num);
							break;
						case "3":
							int fil = Integer.parseInt(param[1]);
							int col = Integer.parseInt(param[2]);
							N = new Negre(col, fil);
							break;
						case "4":
							System.out.println(B.getNum());
							break;
						case "5":
							int num2 = Integer.parseInt(param[1]);
							B.setNum(num2);
							System.out.println(B.getNum());
							break;
						case "6":
							System.out.println(B.isBlanc());
							break;
						case "7":
							System.out.println(B.isNegre());
							break;
						case "8":
							System.out.println(N.getColumna());
							break;
						case "9":
							int col2 = Integer.parseInt(param[1]);
							N.setColumna(col2);
							System.out.println(N.getColumna());
							break;
						case "10":
							System.out.println(N.getFila());
							break;
						case "11":
							int fil2 = Integer.parseInt(param[1]);
							N.setFila(fil2);
							System.out.println(N.getFila());
							break;
						case "12":
							System.out.println(N.isNegre());
							break;
						case "13":
							System.out.println(N.isBlanc());
							break;
						case "14":
							int xN = Integer.parseInt(param[1]);
							int yN = Integer.parseInt(param[2]);
							int xB = Integer.parseInt(param[3]);
							int yB = Integer.parseInt(param[4]);
							B.setX(xB);
							B.setY(yB);
							N.setX(xN);
							N.setY(yN);
							System.out.println("Negre: x -> " + N.getX() + ", y -> " + N.getY());
							System.out.println("Blanc: x -> " + B.getX() + ", y -> " + B.getY());
						default:
							System.out.println("Try another option nigga");
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
