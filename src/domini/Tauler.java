package domini;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tauler {

    private String id;
    private Casella[][] casellas;
    private Casella[][] solucio;
    private int nsol;
    private int col;
    private int fil;
    private TipusDificultat dificultat;
    private boolean acabat;
    private boolean publico;


    public Tauler() {
        casellas = null;
        solucio = null;
    }

    public Tauler(Casella[][] casellas) {
        this.casellas = casellas;
        col = casellas[0].length;
        fil = casellas.length;
        solucio = null;
        nsol = 0;
    }

    public Tauler(int f, int c) {
        this.casellas = new Casella[f][c];
    }

    public Tauler(Casella[][] casellas, TipusDificultat dificultat, boolean acabat, boolean publi) {
        this.casellas = casellas;
        solucio = null;
        col = casellas[0].length;
        fil = casellas.length;
        this.dificultat = dificultat;
        this.acabat = acabat;
        this.publico = publi;
        nsol = 0;
    }

    public Tauler(String name, Casella[][] generateKakuro, int row, int col, TipusDificultat tipusDificultat, boolean b, boolean b1) {
        this.id = name;
        this.casellas = generateKakuro;
        this.fil = row;
        this.col = col;
        this.dificultat = tipusDificultat;
        this.acabat = b;
        this.publico = b1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Casella[][] getCasellas() {
        return casellas;
    }

    public void setCasellas(Casella[][] casellas) {
        this.casellas = casellas;
    }

    public int getNsol() {
        return nsol;
    }

    public void setNsol(int nsol) {
        this.nsol = nsol;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getFil() {
        return fil;
    }

    public void setFil(int fil) {
        this.fil = fil;
    }

    public TipusDificultat getDificultat() {
        return dificultat;
    }

    public void setDificultat(TipusDificultat dificultat) {
        this.dificultat = dificultat;
    }

    public boolean isAcabat() {
        return acabat;
    }

    public void setAcabat(boolean acabat) {
        this.acabat = acabat;
    }

    public boolean isPublic() {
        return publico;
    }

    public void setPublic(boolean publi) {
        this.publico = publi;
    }

    public Casella[][] getSolucio() {
        if (solucio == null) {
            Solver s = new Solver();
            s.solve(this);
            if (nsol == 0) System.out.println("No hi ha solucio"); //Serà una excepció
        }
        return solucio;
    }

    public void setSolucio(Casella[][] solucio) {
        this.solucio = solucio;
    }

    @Override
    public String toString() {

        String s = fil + "," + col + "\n";


        for (int i = 0; i < casellas.length; i++) {
            for (int j = 0; j < casellas[i].length; j++) {
                if (casellas[i][j] instanceof Negre) {
                    if (((Negre) casellas[i][j]).getColumna() != 0 && ((Negre) casellas[i][j]).getFila() != 0) {
                        s = s.concat("C" + ((Negre) casellas[i][j]).getColumna() + "F" + ((Negre) casellas[i][j]).getFila());
                    } else if (((Negre) casellas[i][j]).getColumna() != 0) {
                        s = s.concat("C" + ((Negre) casellas[i][j]).getColumna());
                    } else if (((Negre) casellas[i][j]).getFila() != 0) {
                        s = s.concat("F" + ((Negre) casellas[i][j]).getFila());
                    } else {
                        s = s.concat("*");
                    }
                } else {
                    if (((Blanc) casellas[i][j]).getNum() == 0) s = s.concat("?");
                    else s = s.concat(((Blanc) casellas[i][j]).getNum() + "");
                }

                if (j + 1 != casellas[i].length) s = s.concat(",");

            }
            s = s.concat("\n");
        }
        return s;
    }

    public String imprimirSolucio() {

        String s = nsol+"\n"+solucio.length + "," + solucio[0].length + "\n";


        for (int i = 0; i < solucio.length; i++) {
            for (int j = 0; j < solucio[i].length; j++) {
                if (solucio[i][j] instanceof Negre) {
                    if (((Negre) solucio[i][j]).getColumna() != 0 && ((Negre) solucio[i][j]).getFila() != 0) {
                        s = s.concat("C" + ((Negre) solucio[i][j]).getColumna() + "F" + ((Negre) solucio[i][j]).getFila());
                    } else if (((Negre) solucio[i][j]).getColumna() != 0) {
                        s = s.concat("C" + ((Negre) solucio[i][j]).getColumna());
                    } else if (((Negre) solucio[i][j]).getFila() != 0) {
                        s = s.concat("F" + ((Negre) solucio[i][j]).getFila());
                    } else {
                        s = s.concat("*");
                    }
                } else {
                    if (((Blanc) solucio[i][j]).getNum() == 0) s = s.concat("?");
                    else s = s.concat(((Blanc) solucio[i][j]).getNum() + "");
                }

                if (j + 1 != solucio[i].length) s = s.concat(",");

            }
            s = s.concat("\n");
        }
        return s;
    }

    //Metode que genera els dominis de les caselles blanques
    public void updatePossibilities() {
        int[] nums = {1,2,3,4,5,6,7,8,9};

        Set<Integer> set = new HashSet<>();

        //Mirem domini per columnes
        for (int i = 1; i < col; i++) {
            for (int j = 0; j < fil; j++) {
                if (casellas[j][i].isNegre()) {
                    if (((Negre) casellas[j][i]).getColumna() != 0) {
                        int aux = 1;
                        while (j + aux < fil && casellas[j + aux][i].isBlanc()) aux++;
                        set = combination(nums, ((Negre) casellas[j][i]).getColumna(), aux-1);
                    }
                } else {
                    ((Blanc) casellas[j][i]).getPossibles().addAll(set);
                }
            }
        }
        //Mirem domini per files i fem intersecció amb el domini per columnes d'abans
        for (int i = 1; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                if (casellas[i][j].isNegre()) {
                    if (((Negre) casellas[i][j]).getFila() != 0) {
                        int aux = 1;
                        while (j + aux < col && casellas[i][j+aux].isBlanc()) aux++;
                        set = combination(nums, ((Negre) casellas[i][j]).getFila(), aux-1);
                    }
                } else {
                    ((Blanc) casellas[i][j]).getPossibles().retainAll(set);
                }
            }
        }
    }

    //Metode combinatori per trobar els possibles numeros del domini de la suma en tants de digits
    private Set<Integer> combination(int[] candidates, int target, int digits) {

        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> result = new HashSet<>();
        backTrack(result, list, candidates, target, 0, digits);

        return result;
    }

    private void backTrack(Set<Integer> result,
                                  List<Integer> list, int[] candidates, int target,
                                  int position, int digits) {

        int sum = 0;
        for (int x: list) {
            sum += x;
        }

        if (sum == target && list.size() == digits) {
            result.addAll(list);
            return;
        }

        if (sum < target && list.size() < digits)
        {
            for (int i = position; i < candidates.length; i++)
            {
                if(position != i
                        && candidates[i] == candidates[i-1]) {
                    continue;
                }
                list.add(candidates[i]);
                backTrack(result, list, candidates, target, i + 1, digits);
                list.remove(list.size() - 1);
            }
        }
    }

    public Casella[][] clonar() {

        Casella[][] c = new Casella[casellas.length][casellas[0].length];

        for (int i = 0; i < casellas.length; i++) {
            for (int j = 0; j < casellas[0].length; j++) {
                if (casellas[i][j].isNegre()) {
                    c[i][j] = new Negre(((Negre) casellas[i][j]).getColumna(), ((Negre) casellas[i][j]).getFila());
                } else {
                    c[i][j] = new Blanc(((Blanc) casellas[i][j]).getNum());
                    if (((Blanc) casellas[i][j]).getNum() == 0)
                        ((Blanc) c[i][j]).setPossibles(((Blanc) casellas[i][j]).getPossibles());
                }
            }
        }

        return c;

    }


}