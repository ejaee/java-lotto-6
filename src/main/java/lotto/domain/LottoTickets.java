package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAutoGenerator;

public class LottoTickets implements Iterable<Lotto> {

    private List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets(int lottoQuantity, LottoAutoGenerator lottoAutoGenerator) {
        for (int idx = 1; idx <= lottoQuantity; idx++) {
            lottoTickets.add(lottoAutoGenerator.generateLotto());
        }
    }

    public int size() {
        return lottoTickets.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoTickets.iterator();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottoTickets) {
            stringBuilder.append(lotto.toString())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
