package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.CarRaceGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AppConfig appconfig = new AppConfig();

        InputView inputView = appconfig.inputView();
        List<String> input = inputView.readCarNames();
        int count = inputView.readNumber();

        CarRaceGame game = appconfig.carRaceGame();
        String result = game.run(input,count);

        OutputView outputView = appconfig.outputView();
        outputView.printWinner(result);
    }
}
