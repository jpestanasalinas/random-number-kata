public class NaturalNumber {

    private final int value;

    public NaturalNumber(int value) {
        if(value < 0) throw new IllegalArgumentException("natural number must be positive");

        this.value = value;
    }

    public boolean equalTo(NaturalNumber otherNumber) {
        return value == otherNumber.value;
    }

    public boolean differentThan(NaturalNumber otherNumber) {
        return value != otherNumber.value;
    }

    public boolean higherThan(NaturalNumber otherNumber) {
        return value > otherNumber.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
