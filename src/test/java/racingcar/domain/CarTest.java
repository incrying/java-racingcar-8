package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessageConstants;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
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

    @DisplayName("분할된 이름 중 공백이 있으면 에러를 반환한다.")
    @Test
    void validationTest(){
        String carName = "";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new Car(carName));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessageConstants.INVALID_CAR_NAME);
    }

    @DisplayName("분할된 이름 중 5자를 넘는 이름이 있으면 에러를 반환한다.")
    @Test
    void validationTest2(){
        String carName = "incrying";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new Car(carName));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessageConstants.CAR_NAME_TOO_LONG);
    }

    @DisplayName("Car의 Position 값이 증가하는지 확인한다.")
    @Test
    void moveCarTest(){
        Car car = new Car("daun");
        car.moveCar();

        car.printResult();

        String expectedOutput = "daun : -\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("Car 객체에 담긴 정보를 출력한다.")
    @Test
    void printResultTest(){
        String input = "daun";

        Car car = new Car(input);
        car.printResult();

        String expectedOutput = "daun : \n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("최대 posotion을 반환한다.")
    @Test
    void findMaxTest(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car1");

        car1.moveCar();

        List<Car> cars = List.of(car1,car2);
        int result = Car.findMaxPosition(cars);

        int expectedResult = 1;
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("승리자 이름을 String으로 반환한다.")
    @Test
    void findWinnerTest(){
        Car car1 = new Car("daun");
        Car car2 = new Car("java");
        Car car3 = new Car("car3");

        car1.moveCar();
        car2.moveCar();

        List<Car> cars = List.of(car1,car2,car3);
        String result = Car.findWinner(cars);

        String expectedResult = "daun,java";
        assertThat(result).isEqualTo(expectedResult);
    }
}
