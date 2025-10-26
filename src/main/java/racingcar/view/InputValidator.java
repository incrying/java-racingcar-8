package racingcar.view;


import racingcar.exception.ErrorMessageConstants;

import java.util.List;

public class InputValidator {
    static void validateCarNames(String input){
        if (input.isBlank())
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_CAR_NAME);
    }

    static void checkDuplicateName(List<String> input){
        if(input.size() != input.stream().distinct().count())
            throw new IllegalArgumentException(ErrorMessageConstants.DUPLICATE_CAR_NAME);
    }

    static void validateCount(String input){
        if (input.isBlank())
            throw new IllegalArgumentException(ErrorMessageConstants.BLANK_COUNT);
        if (!isNumberic(input))
            throw new IllegalArgumentException(ErrorMessageConstants.NON_DIGIT_COUNT);
    }

    static boolean isNumberic(String input){
        return input.chars().allMatch(Character::isDigit);
    }
}
