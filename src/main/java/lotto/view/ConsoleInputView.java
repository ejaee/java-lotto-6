package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {

    public String scanMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return scan();
    }

    public String scanWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        return scan();
    }

    public String scanBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        return scan();
    }

    private String scan() {
        return Console.readLine();
    }
}
