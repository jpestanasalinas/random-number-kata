import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NaturalNumberTest {

    @Test
    public void natural_number_cannot_be_negative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new NaturalNumber(-1)
        );

        assertEquals("natural number must be positive", exception.getMessage());
    }

}