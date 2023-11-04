package lotto;

import java.text.DecimalFormat;
import lotto.domain.Money;

public class WinningAmountsCalculator {

    private int winningAmounts;

    public WinningAmountsCalculator() {
    }

    public double calculateStatistics(LottoTicketsResult lottoTicketsResult, Money money) {
        int winningAmounts = calculateWinningAmounts(lottoTicketsResult);

        DecimalFormat df = new DecimalFormat("#.0");
        double statistics = ((double)winningAmounts / money.getMoney()) * 100;
        return Double.parseDouble(df.format(statistics));
    }


    private int calculateWinningAmounts(LottoTicketsResult lottoTicketsResult) {
        return lottoTicketsResult.calculateLottoTicketResult();
    }

}
