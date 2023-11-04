package lotto.domain;

public class BonusNumber {

    int bonusNumber;

    public BonusNumber(String inputBonusNumber) {
        validateBonusNumber(inputBonusNumber);
        this.bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    private void validateBonusNumber(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private boolean contains(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
