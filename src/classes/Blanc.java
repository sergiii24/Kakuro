package classes;

public class Blanc extends Casella {

    int num;

    public Blanc() {
        this.num = 0;
    }
    
    public Blanc(int num) {
        this.num = num;
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
}
