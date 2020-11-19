
package classes;

import java.util.*;

public class Board {

    public Casella[][] getCasellas() {
        return casellas;
    }

    public void setCasellas(Casella[][] casellas) {
        this.casellas = casellas;
    }

    private Casella[][] casellas;
    private int col;
    private int fil;
    private HashMap<Position, HashSet<Integer>> possibilities;
    private List<Position> columnes;
    private List<Position> files;


    public Board(Casella[][] casellas) {
        this.casellas = casellas;
        col = casellas[0].length;
        fil = casellas.length;
        columnes = new ArrayList<>();
        files = new ArrayList<>();
        possibilities = new HashMap<>();
        for (int i = 0; i < fil; i++)
            for (int j = 0; j < col; j++)
                if(casellas[i][j].isNegre())  {

                    if(((Negre)casellas[i][j]).getFila()!=0) files.add(new Position(i,j));
                    if(((Negre)casellas[i][j]).getColumna()!=0) columnes.add(new Position(i,j));

                }



    }




    public boolean isFilled() {

        for (int i = 0; i < fil; i++)
            for (int j = 0; j < col; j++)
                if(casellas[i][j].isEmpty()) return false;

                return true;

    }

    /*public void updatePossibilities() {
        int[] nums = {1,2,3,4,5,6,7,8,9};

        for (Position p : columnes ) {
            int n = getDigitsC(p);

            List<List<Integer>> values = CombiGenerator.combinationSum2( nums , ((Negre)casellas[p.getI()][p.getJ()]).getColumna() , n);
            for (int a = 0; a<n; a++) {
                HashSet<Integer> set = new HashSet<>();
                for (List<Integer> l: values
                     ) {
                    set.addAll(l);
                }
                possibilities.put(new Position(p.getI()+a, p.getJ()), set);
            }

        }

        for (Position p : files ) {
            int n = getDigitsF(p);

            List<List<Integer>> values = CombiGenerator.combinationSum2( nums , ((Negre)casellas[p.getI()][p.getJ()]).getColumna() , n);
            for (int a = 0; a<n; a++) {
                HashSet<Integer> set = new HashSet<>();
                for (List<Integer> l: values
                ) {
                    set.addAll(l);
                }
                Position pos = new Position(p.getI(), p.getJ()+a);
                if (possibilities.containsKey(pos)){
                    possibilities.get(pos).retainAll(set);
                }
                else possibilities.put(new Position(p.getI(), p.getJ()+a), set);
            }

        }



    }*/

    private int getDigitsC(Position p) {

        int i = p.getI()+1;
        int j = p.getJ();
        int d = 0;
        while (i<fil && casellas[i][j].isValid()) {
            i++;
            d++;
        }

        return d;

    }

    private int getDigitsF(Position p) {

        int i = p.getI();
        int j = p.getJ()+1;
        int d = 0;
        while (j < col && casellas[i][j].isValid()) {
            j++;
            d++;
        }

        return d;

    }

    @Override
    public String toString() {

        String s = "";

        for (int i = 0; i < casellas.length; i++) {
            for (int j = 0; j < casellas[i].length; j++) {
                if(casellas[i][j] instanceof Negre) {
                    if(((Negre) casellas[i][j]).getColumna() != 0 && ((Negre) casellas[i][j]).getFila() != 0) {
                        s = s.concat("C" + ((Negre)casellas[i][j]).getColumna() + "F" + ((Negre)casellas[i][j]).getFila()+"\t" );
                    }
                    else if(((Negre)casellas[i][j]).getColumna() != 0) {
                        s = s.concat("C" + ((Negre)casellas[i][j]).getColumna() + "\t");
                    }
                    else if(((Negre)casellas[i][j]).getFila() != 0) {
                        s = s.concat("F" + ((Negre)casellas[i][j]).getFila() + "\t");
                    }
                    else {
                        s = s.concat("*\t");
                    }
                }
                else {
                    s = s.concat(possibilities.get(new Position(i,j)).toString()+"\t");
                }
            }
            s = s.concat("\n");
        }

        return "Board{" + s+                '}';
    }


    public Position bestPosition() {

        int best = 10;
        int a = 0, b = 0;
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                if (casellas[i][j].isBlanc() && ((Blanc)casellas[i][j]).getPossibles().size() < best) {
                    a=i;
                    b=i;
                    best = ((Blanc)casellas[i][j]).getPossibles().size();
                }
            }
        }
        return new Position(a,b);
    }

/*
    private void update() {

        int r = 0, s = 0, suma = 0;

        boolean nou = false;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(c[i][j].isNegre()){
                    if(nou) {
                        ((Negre)c[r][s]).setFila(suma);
                        suma = 0;
                        nou = false;
                    }
                    r = i;
                    s = j;
                } else {
                    suma+=((Blanc)c[i][j]).getNum();
                    nou = true;
                }
            }
        }

        if(nou)
            ((Negre)c[r][s]).setFila(suma);

        r = 0;
        s = 0;
        suma = 0;
        nou = false;

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                if(c[j][i].isNegre()){
                    if(nou) {
                        ((Negre)c[r][s]).setColumna(suma);
                        suma = 0;
                        nou = false;
                    }
                    r = j;
                    s = i;
                } else {
                    suma+=((Blanc)c[j][i]).getNum();
                    nou = true;
                }
            }
        }

        if(nou)
            ((Negre)c[r][s]).setColumna(suma);


    }*/


}

