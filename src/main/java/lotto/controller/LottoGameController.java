package lotto.controller;

import lotto.LottoTicketsResult;
import lotto.domain.LottoTickets;
import lotto.WinningLotto;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.service.LottoGameService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameController {

    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(ConsoleInputView inputView, ConsoleOutputView outputView,
                               LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        Money money = inputMoney();

        LottoTickets lottoTickets = lottoGameService.generateLottoTickets(money);
        outputView.printLottoTickets(lottoTickets);

        String inputWinningLotto = inputView.scanWinningLotto();
        WinningLotto winningLotto = lottoGameService.generateWinningLotto(inputWinningLotto);

        String inputBonusNumber = inputView.scanBonusNumber();
        BonusNumber bonusNumber = lottoGameService.generateBonusNumber(inputBonusNumber);

        LottoTicketsResult lottoTicketsResult = lottoGameService.generateLottoResult
                (lottoTickets, winningLotto, bonusNumber);

        outputView.printLottoTicketsResult(lottoTicketsResult);
        double lottoResultStatistics = lottoGameService.calculateResult(lottoTicketsResult, money);
        outputView.printLottoResultStatistics(lottoResultStatistics);
    }

    private Money inputMoney() {
        try {
            String inputMoney = inputView.scanMoney();
            Money money = lottoGameService.generateMoney(inputMoney);
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            inputMoney();
        }
        return null;
    }


}
