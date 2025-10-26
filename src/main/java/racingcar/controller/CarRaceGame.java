package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceGame {
    public String run(List<String> carNames, int raceCount){
        List<Car> cars = createCar(carNames);

        Race race = new Race();
        for (int i=0;i<raceCount;i++)
            race.runRace(cars);

        String result = Car.findWinner(cars);
        return  result;
    }

    private List<Car> createCar(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }
}
