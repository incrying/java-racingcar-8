package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @DisplayName("자동차 이름을 입력받아 리스트로 반환한다.")
    @Test
    void carNameInputTest(){
        String testInput="daun,java\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        InputView inputView = new InputView();
        List<String> carNames = inputView.readCarNames();

        assertThat(carNames).containsExactly("daun","java");
    }

    @DisplayName("레이스의 횟수를 입력받아 정수로 반환한다.")
    @Test
    void countInputTest(){
        String testInput="2\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        InputView inputView = new InputView();
        int output = inputView.readNumber();

        assertThat(output).isEqualTo(2);
    }
}
