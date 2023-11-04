package lotto;

public enum Rank {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NONE(0);

    private int winningAmounts;

    Rank(int winningAmounts) {
        this.winningAmounts = winningAmounts;
    }

    public int getWinningAmounts() {
        return winningAmounts;
    }
}
