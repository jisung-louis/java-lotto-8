package lotto.domain;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    public static int calculateCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}