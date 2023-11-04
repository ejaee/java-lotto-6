package lotto;

public class LottoResult {
    private final int matchingCount;
    private final boolean isBonus;

    public LottoResult(int matchingCount, boolean isBonus) {
        this.matchingCount = matchingCount;
        this.isBonus = isBonus;
    }

    public Rank calculateLottoResult() {
        if (matchingCount == 6) {
            return Rank.FIRST;
        } else if (matchingCount == 5 && isBonus) {
            return Rank.SECOND;
        } else if (matchingCount == 5) {
            return Rank.THIRD;
        } else if (matchingCount == 4) {
            return Rank.FOURTH;
        } else if (matchingCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
