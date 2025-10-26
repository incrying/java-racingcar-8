package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessageConstants;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @DisplayName("자동차 이름이 공백일 경우 에러를 출력한다.")
    @Test
    void validateCarNamesTest(){
        String input = "";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> InputValidator.validateCarNames(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessageConstants.INVALID_CAR_NAME);
    }

    @DisplayName("자동차 이름이 중복될 경우 에러를 출력한다.")
    @Test
    void duplicateCarNamesTest(){
        List<String> input = List.of("java", "java");

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> InputValidator.checkDuplicateName(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessageConstants.DUPLICATE_CAR_NAME);
    }

    @DisplayName("레이스 진행 횟수가 공백일 경우 에러를 출력한다.")
    @Test
    void blankCountTest(){
        String input = "";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> InputValidator.validateCount(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessageConstants.BLANK_COUNT);

    }

    @DisplayName("레이스 진행 횟수가 자연수가 아닐 경우 에러를 출력한다.")
    @Test
    void nonDigitCountTest(){
        String input = "-5";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> InputValidator.validateCount(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessageConstants.NON_DIGIT_COUNT);

    }
}
