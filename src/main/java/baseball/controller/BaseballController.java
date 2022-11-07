package baseball.controller;

import baseball.service.BaseBallService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BaseBallService baseBallService = new BaseBallService();

    public void gameStart() {
        do {
            inProgress();
        } while (restart());
    }

    public boolean restart() {
        return true;
    }

    public void inProgress() {
        inputView.inputNumber();
    }

    public void initGame() {
        outputView.printInitGameMessage();
    }
}
