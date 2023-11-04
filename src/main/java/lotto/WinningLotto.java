package lotto;

import lotto.domain.Lotto;

public class WinningLotto {
    Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getLotto() {
        return lotto;
    }
}
