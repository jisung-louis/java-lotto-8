package lotto;

import lotto.domain.LottoStore;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.readPurchaseAmount();
        int count = LottoStore.calculateCount(purchaseAmount);
        System.out.println(count + "개를 구매했습니다.");
    }
}