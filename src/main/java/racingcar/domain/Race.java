package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.List;

public class Race {

    public void runRace(List<Car> cars){
        cars.stream().filter(car -> NumberGenerator.generate()>=4).forEach(Car::moveCar);
        printRoundResult(cars);
    }
    public void printRoundResult(List<Car> cars){
        cars.stream().forEach(Car::printResult);
        System.out.println("");
    }
}