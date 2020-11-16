package classes;

import java.util.List;

public class Blanc extends Casella {

    int num;

    public Blanc(int num) {
        this.num = num;
    }

    public Blanc() {
        this.num = 0;
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