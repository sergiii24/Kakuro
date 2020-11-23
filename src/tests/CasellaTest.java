package tests;

import static org.junit.Assert.*;

import domini.Blanc;
import domini.Negre;
import org.junit.Test;

public class CasellaTest {

	//---
	//Blanc
	//---
	
	@Test
	public void creadoresBlanc() {
		//creadora sense numero
		Blanc b = new Blanc();
		assertEquals("Numero incorrecte(sense numero)", 0, b.getNum());
		
		//creadora amb numero
		b = new Blanc(5);
		assertEquals("Numero incorrecte(amb numero)", 5, b.getNum());
	}
	
	@Test
	public void getNum() {
		Blanc b = new Blanc(7);
		assertEquals("Retorna numero incorrecte", 7, b.getNum());
	}
	
	public void setNum() {
		//assignar numero sense previament tenir un
		Blanc b = new Blanc();
		b.setNum(4);
		assertEquals("No s'ha guardat el numero", 4, b.getNum());
		
		//assignar numero on ja hi havia un altre
		b.setNum(8);
		assertEquals("No s'ha guardat el nou numero", 8, b.getNum());
	}

	//---
	//Negre
	//---
	
	@Test
	public void creadoresNegre() {
		//creadora sense numero
		Negre n = new Negre();
		assertEquals("Numero incorrecte de columna(sense numero)", 0, n.getColumna());
		assertEquals("Numero incorrecte de fila(sense numero)", 0, n.getFila());
		
		//creadora amb numero
		n = new Negre(36, 17);
		assertEquals("Numero incorrecte de columna(amb numero)", 36, n.getColumna());
		assertEquals("Numero incorrecte de fila(amb numero)", 17, n.getFila());
	}
	
	@Test
	public void getColumna() {
		Negre n = new Negre(19,6);
		assertEquals("Numero incorrecte de columna", 19, n.getColumna());
	}
	
	@Test
	public void setColumna() {
		//assignar numero sense previament tenir un
		Negre n = new Negre();
		n.setColumna(22);
		assertEquals("No s'ha guardat el numero", 22, n.getColumna());
		
		//assignar numero on ja hi havia un altre
		n.setColumna(25);
		assertEquals("No s'ha guardat el nou numero", 25, n.getColumna());
	}
	
	@Test
	public void getFila() {
		Negre n = new Negre(19,6);
		assertEquals("Numero incorrecte de columna", 6, n.getFila());
	}
	
	@Test
	public void setFila() {
		//assignar numero sense previament tenir un
		Negre n = new Negre();
		n.setFila(23);
		assertEquals("No s'ha guardat el numero", 23, n.getFila());
		
		//assignar numero on ja hi havia un altre
		n.setFila(26);
		assertEquals("No s'ha guardat el nou numero", 26, n.getFila());
	}
}
