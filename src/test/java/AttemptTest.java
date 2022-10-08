import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttemptTest {

    private Attempt attempt;

    @BeforeEach
    public void setUp() {
        attempt = new Attempt();
    }

    @Test
    public void attempt_cannot_be_increased_above_three() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            attempt.make();
            attempt.make();
            attempt.make();
            attempt.make();
        });

        assertThat(exception.getMessage(), equalTo("max number of attemps is three"));
    }

    @Test
    public void third_attempt_is_the_last() {
        attempt.make();
        attempt.make();
        attempt.make();

        assertTrue(attempt.isLast());
    }

    @Test
    public void second_attempt_is_not_the_last() {
        attempt.make();
        attempt.make();

        assertTrue(attempt.notLast());
    }

}