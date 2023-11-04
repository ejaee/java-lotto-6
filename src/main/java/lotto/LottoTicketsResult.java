package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoTicketsResult implements Iterable<LottoResult> {

    private final List<LottoResult> lottoTicketsResult;
    private final int lottoAmounts;

    public LottoTicketsResult(List<LottoResult> lottoTicketsResult, int lottoAmounts) {
        this.lottoTicketsResult = lottoTicketsResult;
        this.lottoAmounts = lottoAmounts;
    }

    public int calculateLottoTicketResult() {
        int sum = 0;
        for (LottoResult lottoResult : lottoTicketsResult) {
            Rank rank = lottoResult.calculateLottoResult();
            sum += rank.getWinningAmounts();
        }
        return sum;
    }

    public int getLottoResultCount(Rank rank) {
        int count = 0;

        for (LottoResult lottoResult : lottoTicketsResult) {
            int matchingCount = lottoResult.getMatchingCount();
            if (rank == Rank.SECOND) {
                if (matchingCount == 5 && lottoResult.isBonus()) {
                    count++;
                    continue;
                }
            }
            if (rank == Rank.FIRST) {
                if (matchingCount == 6) {
                    count++;
                }
            } else if (rank == Rank.THIRD) {
                if (matchingCount == 5) {
                    count++;
                }
            } else if (rank == Rank.FOURTH) {
                if (matchingCount == 4) {
                    count++;
                }
            } else if (rank == Rank.FIFTH) {
                if (matchingCount == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getLottoAmounts() {
        return lottoAmounts;
    }

    @Override
    public Iterator<LottoResult> iterator() {
        return lottoTicketsResult.iterator();
    }
}
