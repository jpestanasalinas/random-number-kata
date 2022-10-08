import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        FakePositiveNumberGenerator fakePositiveNumberGenerator = new FakePositiveNumberGenerator();
        game = new Game(fakePositiveNumberGenerator);
    }

    @Test
    public void when_player_match_number_then_guess_number_returns_victory_message() {
        NaturalNumber matchNumber = new NaturalNumber(FakePositiveNumberGenerator.RANDOM_NUMBER);
        String victoryMessage = game.guessNumber(matchNumber);

        assertThat(victoryMessage, equalTo("Correct, you won!"));
    }

    @Test
    public void when_player_number_is_lower_then_guess_number_returns_higher_message() {
        NaturalNumber lowerNumber = new NaturalNumber(FakePositiveNumberGenerator.RANDOM_NUMBER - 1);
        String lowerMessage = game.guessNumber(lowerNumber);

        assertThat(lowerMessage, equalTo("The number is higher"));
    }

    @Test
    public void when_player_number_is_higher_then_guess_number_returns_lower_message() {
        NaturalNumber higherNumber = new NaturalNumber(FakePositiveNumberGenerator.RANDOM_NUMBER + 1);
        String lowerMessage = game.guessNumber(higherNumber);

        assertThat(lowerMessage, equalTo("The number is lower"));
    }

    @Test
    public void when_player_use_three_attempts_failing_then_loose_game() {
        game.guessNumber(new NaturalNumber(FakePositiveNumberGenerator.RANDOM_NUMBER + 1));
        game.guessNumber(new NaturalNumber(FakePositiveNumberGenerator.RANDOM_NUMBER + 1));
        String loosedGame = game.guessNumber(new NaturalNumber(FakePositiveNumberGenerator.RANDOM_NUMBER + 1));

        assertThat(loosedGame, equalTo("You loose"));

    }

}

class FakePositiveNumberGenerator extends PositiveRandomGenerator {

    public static final int RANDOM_NUMBER = 5;

    @Override
    public NaturalNumber generate() {
        return new NaturalNumber(RANDOM_NUMBER);
    }

}
