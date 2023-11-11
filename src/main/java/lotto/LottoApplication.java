package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoStat;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.dto.LottoStatsResponse;
import lotto.ui.dto.MyLottosResponse;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        Money money = new Money(inputMoney);

        OutputView.outputPurchaseCount(money.purchaseCount());

        MyLottos myLottos = LottoFactory.buy(money);
        OutputView.outputMyLottos(MyLottosResponse.from(myLottos));

        List<Integer> nums = InputView.winningNumbers();
        WinningLotto winningLotto = new WinningLotto(nums);

        LottoStat lottoStat = new LottoStat();
        lottoStat.check(myLottos, winningLotto);

        OutputView.outputLottoStats(LottoStatsResponse.from(lottoStat, money));
    }

}
