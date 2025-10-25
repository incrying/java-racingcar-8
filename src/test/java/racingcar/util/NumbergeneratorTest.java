package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbergeneratorTest {
    @DisplayName("0-9사이의 난수를 반환한다.")
    @Test
    void generateNumber() {
        int randomNumber = NumberGenerator.generate();

        assertThat(randomNumber).isBetween(0, 9);
    }
}
