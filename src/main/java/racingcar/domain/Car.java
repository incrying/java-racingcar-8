package racingcar.domain;


import racingcar.exception.ErrorMessageConstants;

import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String car;
    private int position;

    public Car(String string){
        validation(string);
        this.car = string;
    }

    public static String findWinner(List<Car> cars){

        int maxCount = findMaxPosition(cars);
        List<String> result = cars.stream()
                .filter(car -> car.position == maxCount)
                .map(car ->car.car)
                .collect(Collectors.toList());

        return String.join(",",result);
    }

    public static int findMaxPosition(List<Car> cars){
        int maxCount = 0;
        for (Car c : cars) {
            if (c.position>maxCount)
                maxCount = c.position;
        }
        return maxCount;
    }
    public void printResult(){
        System.out.println(car + " : " + "-".repeat(position));
    }

    public void moveCar(){
        this.position++;
    }

    void validation(String string) {
        if (string.length() > 5)
            throw new IllegalArgumentException(ErrorMessageConstants.CAR_NAME_TOO_LONG);
        if (string.isBlank())
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_CAR_NAME);
    }
}