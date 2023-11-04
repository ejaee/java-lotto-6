package lotto.domain;

public class Money {

    private static final int LOTTO_UNITS = 1000;
    private final int money;

    public Money(String inputMoney) {
        validateMoney(inputMoney);
        this.money = Integer.parseInt(inputMoney);
    }

    public void validateMoney(String inputMoney) {
        try {
            int money = Integer.parseInt(inputMoney);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1000원 단위로 입력하세요");
        }
        validateMoneyUnits(money);
    }

    private void validateMoneyUnits(int money) {
        if (money % LOTTO_UNITS != 0)
            throw new IllegalArgumentException();
    }

    public int getMoney() {
        return money;
    }

    public int getLottoQuantity() {
        return money / LOTTO_UNITS;
    }
}
