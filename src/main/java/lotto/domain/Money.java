package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private static void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("돈은 천원단위로만 받을 수 있습니다.");
        }
    }

    public int purchaseCount() {
        return money / LOTTO_PRICE;
    }
}
