public class Game {

    private static final String LOWER_NUMBER_MESSAGE = "The number is lower";
    private static final String HIGHER_NUMBER_MESSAGE = "The number is higher";
    private static final String VICTORY_MESSAGE = "Correct, you won!";
    private static final String LOOSE_MESSAGE = "You loose";

    private final NaturalNumber hiddenNumber;
    private final Attempt attempt;

    public Game(PositiveRandomGenerator positiveRandomGenerator) {
        this.hiddenNumber = positiveRandomGenerator.generate();
        this.attempt = new Attempt();
    }

    public String guessNumber(NaturalNumber guessedNumber) {
        attempt.make();

        if (guess(guessedNumber)) return VICTORY_MESSAGE;
        if (failLastAttempt(guessedNumber)) return LOOSE_MESSAGE;

        if (guessedNumber.higherThan(hiddenNumber)) return LOWER_NUMBER_MESSAGE;

        return HIGHER_NUMBER_MESSAGE;
    }

    private boolean guess(NaturalNumber guessedNumber) {
        return hiddenNumber.equalTo(guessedNumber);
    }

    private boolean failLastAttempt(NaturalNumber guessedNumber) {
        return attempt.isLast() && fail(guessedNumber);
    }

    private boolean fail(NaturalNumber guessedNumber) {
        return hiddenNumber.differentThan(guessedNumber);
    }

}
