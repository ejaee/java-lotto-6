package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

public class MatchingCounter {

    public LottoTicketsResult generateLottoTicketsResult
            (LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            int matchingCount = lotto.countMatchingNumbers(winningLotto.getLotto());
            boolean isBonus = lotto.contains(bonusNumber.getBonusNumber());

            lottoResults.add(new LottoResult(matchingCount, isBonus));
        }
        return new LottoTicketsResult(lottoResults, lottoTickets.size());
    }
}
