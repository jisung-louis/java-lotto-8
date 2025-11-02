package lotto;

import lotto.domain.LottoStore;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.readPurchaseAmount();
        List<Lotto> lottos = LottoStore.buyLottos(purchaseAmount);
        OutputView.printLottos(lottos);

        String winningInput = InputView.readWinningNumbers();
        String bonusInput = InputView.readBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningInput, bonusInput);
    }
}