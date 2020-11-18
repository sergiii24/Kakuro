package classes;

import java.util.ArrayList;
import java.util.List;

public class Blanc extends Casella {

    int num;

    public List<Integer> getPossibles() {
        return possibles;
    }

    public void setPossibles(List<Integer> possibles) {
        this.possibles = possibles;
    }

    List<Integer> possibles;

    public Blanc(int num) {
        this.num = num;
        possibles = new ArrayList<>();
    }

    public Blanc() {
        this.num = 0;
        possibles = new ArrayList<>();
    }

    public int getNum() {
        return num;
    }


    public void setNum(int num) {
        this.num = num;
    }

    public boolean isBlanc() {
        return true;
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public boolean isValid() {
        return true;
    }

}