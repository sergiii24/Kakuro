package classes;

public class Solver {
	private int nsol = 0;
	public Solver() {
		
	}
	
	public int solve(Tauler t) {
		if(!solucionar(t.getCasellas(), 0, 0)) {
			return nsol;
		}
		return -1;
	}
	
	public boolean solucionar(Casella[][] taula, int fila, int columna) {
		//System.out.println("Fila: " + fila + ", Columna2: " + columna);
		int nfil = taula.length;
		int ncol = taula[0].length;
		
		if(fila == nfil) {
			++nsol;
			//System.out.println("Hola");
			Tauler t = new Tauler(taula);
			System.out.println(t.toString());
			return true; 							//Si arribem a una fila invàlida, vol dir que hem resolt el kakuro
		}
		
		if(columna == ncol) return solucionar(taula, fila + 1, 0);		//Si arribem a una columna invàlida, passem a la següent fila
		//System.out.println("Fila: " + fila + ", Columna: " + columna);
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
	
	public boolean esValid(Casella[][] taula, int fila, int columna, int n) {
		if(filValida(taula, fila, columna, n) && colValida(taula, fila, columna, n)) return true;
		else return false;
	}
	
	public boolean filValida(Casella[][] taula, int fila, int columna, int n) {
		int sumTot = 0, sumTmp = n;
		
		for(int j = columna - 1; j >= 0; --j) {
			if(taula[fila][j].isNegre()) {
				sumTot = ((Negre)taula[fila][j]).getFila();
				break;
			}
			if(((Blanc)taula[fila][j]).getNum() == n) {
				//System.out.println("FRepetit");
				return false;
			}
			sumTmp += ((Blanc)taula[fila][j]).getNum();
		}
		//System.out.println("FsumTmp: " + sumTmp + ", FsumTot: " + sumTot);
		if(sumTmp > sumTot) {
			//System.out.println("Massa gran");
			return false;
		}
		
		if(columna == taula[0].length - 1) {
			if(sumTmp < sumTot) {
				//System.out.println("FFinalPetit");
				return false;
			}
		}
		else if(taula[fila][columna + 1].isNegre()) {
			if(sumTmp < sumTot) {
				//System.out.println("FNegrePetit");
				return false;
			}
		}
		//System.out.println("Fila valida");
		return true;
	}
	
	public boolean colValida(Casella[][] taula, int fila, int columna, int n) {
		int sumTot = 0, sumTmp = n;
		
		for(int i = fila - 1; i >= 0; --i) {
			if(taula[i][columna].isNegre()) {
				sumTot = ((Negre)taula[i][columna]).getColumna();
				break;
			}
			if(((Blanc)taula[i][columna]).getNum() == n) return false;
			sumTmp += ((Blanc)taula[i][columna]).getNum();
		}
		//System.out.println("sumTmp: " + sumTmp + ", sumTot: " + sumTot);
		if(sumTmp > sumTot) {
			//System.out.println("Massa gran");
			return false;
		}
		
		if(fila == taula.length - 1) {
			if(sumTmp < sumTot) {
				//System.out.println("FinalPetit");
				return false;
			}
		}
		else if(taula[fila + 1][columna].isNegre()) {
			if(sumTmp < sumTot) {
				//System.out.println("NegrePetit");
				return false;
			}
		}
		
		//System.out.println("Columna valida");
		return true;
	}
}