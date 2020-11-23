package domini;

public class Solver {

	private int nsol;
	private Casella[][] s;

	public Solver() {
		nsol = 0;
	}


	public void solve(Tauler t) {

		//1r - Genero un tauler identic al enunciat al qual li aplicaré el backtracking
		Casella[][] solucio = generaTauler(t.getCasellas());
		//2n - Busca una solució mitjançant backtracking
		long l1 = System.currentTimeMillis();
		solucionar(solucio, 0, 0);
		System.out.println("Ha tardat " + (System.currentTimeMillis() - l1) + " ms");

		if(nsol!=0) {
			t.setSolucio(s);
		}

		t.setNsol(nsol);

	}

	private Casella[][] generaTauler(Casella[][] taulell) {

		Casella[][] nou = new Casella[taulell.length][taulell[0].length];

		for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell[0].length; j++) {
				if(taulell[i][j].isNegre()){
					nou[i][j] = new Negre(((Negre)taulell[i][j]).getColumna(),((Negre)taulell[i][j]).getFila());
				} else {
					nou[i][j] = new Blanc(((Blanc)taulell[i][j]).getNum());
				}
			}
		}

		return nou;

	}
	
	private boolean solucionar(Casella[][] taula, int fila, int columna) {

		int nfil = taula.length;
		int ncol = taula[0].length;

		//Si te dos solucions retorna, que no en busqui més
		if(nsol==2) return true;

		if(fila == nfil) {
			++nsol;
			s = generaTauler(taula);
			return true; 							//Si arribem a una fila invàlida, vol dir que hem resolt el kakuro
		}
		
		if(columna == ncol) return solucionar(taula, fila + 1, 0);		//Si arribem a una columna invàlida, passem a la següent fila
		if(taula[fila][columna].isNegre()) return solucionar(taula, fila, columna + 1);	//Si estem a una casella Negre, passem a la següent
		
		for(int n = 1; n <= 9; ++n) {							//Mirem per cada casella blanca si el número és valid, si ho és mirem la següent casella
			if(esValid(taula, fila, columna, n)) {
				((Blanc)taula[fila][columna]).setNum(n);
				if(solucionar(taula, fila, columna + 1)) return false;
				else ((Blanc)taula[fila][columna]).setNum(0);
			}
		}
		return false;
	}
	
	private boolean esValid(Casella[][] taula, int fila, int columna, int n) {
		if(filValida(taula, fila, columna, n) && colValida(taula, fila, columna, n)) return true;
		else return false;
	}

	private boolean filValida(Casella[][] taula, int fila, int columna, int n) {
		int sumTot = 0, sumTmp = n;
		
		for(int j = columna - 1; j >= 0; --j) {
			if(taula[fila][j].isNegre()) {
				sumTot = ((Negre)taula[fila][j]).getFila();
				break;
			}
			if(((Blanc)taula[fila][j]).getNum() == n) {
				return false;
			}
			sumTmp += ((Blanc)taula[fila][j]).getNum();
		}
		if(sumTmp > sumTot) {
			return false;
		}
		
		if(columna == taula[0].length - 1) {
			if(sumTmp < sumTot) {
				return false;
			}
		}
		else if(taula[fila][columna + 1].isNegre()) {
			if(sumTmp < sumTot) {
				return false;
			}
		}
		return true;
	}

	private boolean colValida(Casella[][] taula, int fila, int columna, int n) {
		int sumTot = 0, sumTmp = n;
		
		for(int i = fila - 1; i >= 0; --i) {
			if(taula[i][columna].isNegre()) {
				sumTot = ((Negre)taula[i][columna]).getColumna();
				break;
			}
			if(((Blanc)taula[i][columna]).getNum() == n) return false;
			sumTmp += ((Blanc)taula[i][columna]).getNum();
		}
		if(sumTmp > sumTot) {
			return false;
		}
		
		if(fila == taula.length - 1) {
			if(sumTmp < sumTot) {
				return false;
			}
		}
		else if(taula[fila + 1][columna].isNegre()) {
			if(sumTmp < sumTot) {
				return false;
			}
		}
		
		//System.out.println("Columna valida");
		return true;
	}
}