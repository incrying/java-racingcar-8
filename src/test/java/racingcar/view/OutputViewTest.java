package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @DisplayName("최종 우승자를 출력한다.")
    @Test
    void outputTest(){
        String winners = "daun, java";


        OutputView outputView = new OutputView();
        outputView.printWinner(winners);

        String expectedOutput = "최종 우승자 : daun, java\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }
}
