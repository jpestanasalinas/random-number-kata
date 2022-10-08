import java.util.Random;

class PositiveRandomGenerator extends Random {

    public static final int MAX_NUMBER = 10;
    public static final int MIN_NUMBER = 1;

    public PositiveRandomGenerator() {
    }

    public NaturalNumber generate() {
        return new NaturalNumber(nextInt(MAX_NUMBER) + MIN_NUMBER);
    }
}
