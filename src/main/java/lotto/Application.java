package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {

        LottoGameController lottoGameController = new LottoGameController
                (new ConsoleInputView(), new ConsoleOutputView(), new LottoGameService());
        lottoGameController.run();
    }
}
