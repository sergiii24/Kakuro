package domini.models;

public class Pair<T1, T2> {

    public final T1 item1;
    public final T2 item2;

    public Pair(T1 item1, T2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public static <T1,T2> Pair<T1,T2> of(final T1 i1, final T2 i2) {
        return new Pair<>(i1, i2);
    }


}
