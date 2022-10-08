public class Attempt {

    private static final int TOTAL_ATTEMPTS = 3;

    private int number;

    public Attempt() {
        this.number = 0;
    }

    public void make() {
        if(number >= TOTAL_ATTEMPTS) throw new IllegalStateException("max number of attemps is three");

        number++;
    }

    public boolean isLast() {
        return number == TOTAL_ATTEMPTS;
    }

    public boolean notLast() {
        return !isLast();
    }
}
