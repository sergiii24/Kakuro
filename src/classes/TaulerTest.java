package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaulerTest {
	
	@Test
	public void creadores() {
		//creadora sense valors
		Tauler t = new Tauler();
		assertNull("Not null", t.getCasellas());
		
		//casellas sense valor
		Casella[][] casellas = new Casella[1][3];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		t = new Tauler(casellas, d, aca, pub);
		assertEquals("Numero de files incorrecte", 1, t.getCasellas().length);
		assertEquals("Numero de columnes incorrecte", 3, t.getCasellas()[0].length);
		assertTrue("Valor de acabat incorrecte", t.isAcabat());
		assertFalse("Valor de public incorrecte", t.isPublic());
		
		//casellas amb valor		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 3; j++) {
					casellas[i][j] = new Blanc();
			}
		}
		
		t = new Tauler(casellas, d, aca, pub);
		assertEquals("Objectes diferents", casellas[0][0], t.getCasellas()[0][0]);
	}
	
	@Test
	public void getCasellas() {
		Casella[][] casellas = new Casella[1][6];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		Tauler t = new Tauler(casellas, d, aca, pub);
		assertEquals("Objectes diferents", casellas, t.getCasellas());
	}
	
	@Test
	public void getSolucio() {
		Casella[][] casellas = new Casella[3][3];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		Tauler t = new Tauler(casellas, d, aca, pub);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
					if(i == 0){
							if(j == 0) casellas[i][j] = new Negre(3,3);
							else  casellas[i][j] = new Negre(3,0);
					}
					else if(j == 0) casellas[i][j] = new Negre(0,3);
					else if(i == j) casellas[i][j] = new Blanc(1);
					else casellas[i][j] = new Blanc(2);
			}
		}
		assertEquals("No soluciona correctament", casellas, t.getSolucio());
	}
	
	@Test
	public void getNumSol() {
		Casella[][] casellas = new Casella[3][3];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		Tauler t = new Tauler(casellas, d, aca, pub);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
					if(i == 0){
							if(j == 0) casellas[i][j] = new Negre(3,3);
							else  casellas[i][j] = new Negre(3,0);
					}
					else if(j == 0) casellas[i][j] = new Negre(0,3);
					else if(i == j) casellas[i][j] = new Blanc(1);
					else casellas[i][j] = new Blanc(2);
			}
		}
		assertEquals("Numero incorrecte de solucions", 2, t.getNumSol());
	}
	
	@Test
	public void getCol() {
		Casella[][] casellas = new Casella[1][6];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		Tauler t = new Tauler(casellas, d, aca, pub);
		assertEquals("Numero de files obtingut incorrecte", 6, t.getCol());
	}
	
	@Test
	public void getFil() {
		Casella[][] casellas = new Casella[6][1];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		Tauler t = new Tauler(casellas, d, aca, pub);
		assertEquals("Numero de files obtingut incorrecte", 6, t.getFil());
	}
	
	@Test
	public void getDificultat() {
		Casella[][] casellas = new Casella[6][1];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		Tauler t = new Tauler(casellas, d, aca, pub);
		assertEquals("Numero de files obtingut incorrecte", TipusDificultat.FACIL , t.getDificultat());
	}
	
	@Test
	public void isAcabat() {
		Casella[][] casellas = new Casella[6][1];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		Tauler t = new Tauler(casellas, d, aca, pub);
		assertTrue("Valor incorrecte de acabat", t.isAcabat());
	}
	
	@Test
	public void isPublic() {
		Casella[][] casellas = new Casella[6][1];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		Tauler t = new Tauler(casellas, d, aca, pub);
		assertFalse("Valor incorrecte de acabat", t.isPublic());
	}
	
	@Test
	public void String() {
		//Tauler sense solucio
		Casella[][] casellas = new Casella[3][3];
		TipusDificultat d = TipusDificultat.FACIL;
		boolean aca = true;
		boolean pub = false;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
					if(i == 0){
							if(j == 0) casellas[i][j] = new Negre(3,3);
							else  casellas[i][j] = new Negre(3,0);
					}
					else if(j == 0) casellas[i][j] = new Negre(0,3);
					else casellas[i][j] = new Blanc(0);
			}
		}
		
		Tauler t = new Tauler(casellas, d, aca, pub);
		String exp = "Tauler casellas=\n"
				+ "C3F3	C3	C3	\n"
				+ "F3	?	?	\n"
				+ "F3	?	?	\n";
		assertEquals("No coincideix string(sense solucio)", exp, t.toString());
		
		//Tauler amb solucio
		for (int i = 1; i < 3; i++) {
			for (int j = 1; j < 3; j++) {
					if(i == j) casellas[i][j] = new Blanc(1);
					else casellas[i][j] = new Blanc(2);
			}
		}
		
		exp = "Tauler casellas=\n"
				+ "C3F3	C3	C3	\n"
				+ "F3	1	2	\n"
				+ "F3	2	1	\n";
		assertEquals("No coincideix string(amb solucio)", exp, t.toString());
		
	}
	
}
