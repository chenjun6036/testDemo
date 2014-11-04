package concurrency;

public class FinalHolder {
    private final int i;

    public FinalHolder(int i) {
        this.i = i;
    }

    public int get() {
        return i;
    }
}
