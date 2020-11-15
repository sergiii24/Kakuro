package Presentació;

import javax.swing.*;

public class VistaInicial {
	//private JFrame vista;
	
	public VistaInicial() {
		JFrame v = new JFrame("Kakuro");
		
		v.setSize(450, 650);
		v.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		VistaInicial vi = new VistaInicial();
	}
}
