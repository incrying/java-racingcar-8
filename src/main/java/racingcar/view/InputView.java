package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        InputValidator.validateCarNames(carNames);
        return parseCarNames(carNames);
    }

    private List<String> parseCarNames(String input) {
        List<String> output = Arrays.asList(input.split(","));
        InputValidator.checkDuplicateName(output);
        return output;
    }

    public int readNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String number = Console.readLine();
        InputValidator.validateCount(number);
        return Integer.parseInt(number);
    }
}