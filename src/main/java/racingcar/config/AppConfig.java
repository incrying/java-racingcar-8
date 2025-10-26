package racingcar.config;

import racingcar.controller.CarRaceGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public CarRaceGame carRaceGame(){
        return new CarRaceGame();
    }

    public InputView inputView(){
        return new InputView();
    }

    public OutputView outputView(){
        return new OutputView();
    }
}
