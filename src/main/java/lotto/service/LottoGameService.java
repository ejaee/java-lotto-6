package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoAutoGenerator;
import lotto.domain.LottoTickets;
import lotto.LottoTicketsResult;
import lotto.MatchingCounter;
import lotto.domain.Money;
import lotto.WinningAmountsCalculator;
import lotto.WinningLotto;

public class LottoGameService {

    private static final int LOTTO_PRICE = 1000;

    public Money generateMoney(String inputMoney) {
        return new Money(inputMoney);
    }

    public LottoTickets generateLottoTickets(Money money) {
        int lottoQuantity = money.getLottoQuantity();

        return new LottoTickets(lottoQuantity, new LottoAutoGenerator());
    }

    public WinningLotto generateWinningLotto(String inputWinningLotto) {
        List<Integer> numbers = Arrays.stream(inputWinningLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinningLotto(new Lotto(numbers));
    }

    public BonusNumber generateBonusNumber(String inputBonusNumber) {
        return new BonusNumber(inputBonusNumber);
    }

    public LottoTicketsResult generateLottoResult
            (LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        MatchingCounter matchingCounter = new MatchingCounter();
        return matchingCounter.generateLottoTicketsResult(lottoTickets, winningLotto, bonusNumber);
    }

    public double calculateResult(LottoTicketsResult lottoTicketsResult, Money money) {
        WinningAmountsCalculator winningAmountsCalculator = new WinningAmountsCalculator();
        return winningAmountsCalculator.calculateStatistics(lottoTicketsResult, money);
    }
}
