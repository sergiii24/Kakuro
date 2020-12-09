package domini;

import java.util.HashSet;
import java.util.Set;

public class Blanc extends Casella {

    private int num;
    private Set<Integer> possibles;

    public Set<Integer> getPossibles() {
        return possibles;
    }

    public void setPossibles(Set<Integer> possibles) {
        this.possibles = possibles;
    }


    public Blanc(int num) {
        this.num = num;
        possibles = new HashSet<>();
    }

    public Blanc() {
        this.num = 0;
        possibles = new HashSet<>();
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

    @Override
    public String toString() {
        return "Blanc{" +
                "num=" + num +
                ", possibles=" + possibles +
                '}';
    }
}
