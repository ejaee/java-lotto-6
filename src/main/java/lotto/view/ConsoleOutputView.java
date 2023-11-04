package lotto.view;

import lotto.LottoTicketsResult;
import lotto.Rank;
import lotto.domain.LottoTickets;

public class ConsoleOutputView {

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        System.out.println(lottoTickets);
    }

    public void printLottoTicketsResult(LottoTicketsResult lottoTicketsResult) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoTicketsResult.getLottoResultCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoTicketsResult.getLottoResultCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoTicketsResult.getLottoResultCount(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoTicketsResult.getLottoResultCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoTicketsResult.getLottoResultCount(Rank.FIRST) + "개");
    }

    public void printLottoResultStatistics(double lottoAmountsStatistic) {
        System.out.println("총 수익률은 " + lottoAmountsStatistic + "%입니다.");
    }

}
