package classes;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;

public class Generador {
	
	private int N;
	private Casella[][] taula;
	
	public Generador() {
		N = 0;
	}
	
	public void llegir_tamany() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		Tauler t = new Tauler(N,N);
		taula = t.getCasellas();
	}
	
	public void generar() {
		Random ran = new Random();
		Tauler t = new Tauler(taula);
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(i == 0 || j == 0) taula[i][j] = new Negre();
				else taula[i][j] = new Blanc();
			}
			
		}
		
		for(int i = 1; i < N; ++i) {
			HashSet<Integer> filarep = new HashSet<Integer>();
			for(int j = 1; j < N; ++j){
				int num = ran.nextInt(9) + 1;
				if(!filarep.add(num)) {
					taula[i][j] = new Negre();
					filarep.clear();
				}
				else if(esColValid(i, j, num)) {
					taula[i][j] = new Blanc();
					((Blanc)taula[i][j]).setNum(num);
				}
				else {
					System.out.println(num);
					taula[i][j] = new Negre();
					filarep.clear();
				}	
			}
		}
		
		System.out.println(t.toString());
		
		for(int i = 1; i < N; ++i) {
			for(int j = 1; j < N; ++j) {
				if(taula[i][j].isNegre() || j == N - 1) sumarFila(i, j);
				if(taula[j][i].isNegre() || i == N - 1) sumarColumna(i, j);
			}
		}
		
		for(int i = 1; i < N; ++i) {
			for(int j = 1; j < N; ++j) {
				if(taula[i][j].isBlanc()) ((Blanc)taula[i][j]).setNum(0);
			}
		}

		System.out.println(t.toString());
		Solver s = new Solver();
		s.solve(t);
	}
	
	public boolean esColValid(int i, int j, int num) {
		HashSet<Integer> colrep = new HashSet<Integer>();
		colrep.add(num);
		for(int row = i; row >= 0 && !taula[row][j].isNegre(); --row) {
			if(!colrep.add(((Blanc)taula[row][j]).getNum())) return false;
		}
		return true;
	}
	
	public void sumarFila(int i, int j) {
		int sumF = 0;
		for(int col = j; col >= 0; --col) {
			if(taula[i][col].isNegre()) {
				((Negre)taula[i][col]).setFila(sumF);
				sumF = 0;
			}
			else sumF += ((Blanc)taula[i][col]).getNum();
		}
	}
	
	public void sumarColumna(int i, int j) {
		int sumC = 0;
		for(int fil = i; fil >= 0; --fil) {
			if(taula[fil][j].isNegre()) {
				((Negre)taula[fil][j]).setColumna(sumC);
				sumC = 0;
			}
			else sumC += ((Blanc)taula[fil][j]).getNum();
		}
	}
}
