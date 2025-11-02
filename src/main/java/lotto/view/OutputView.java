package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottos(List<lotto.Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (lotto.Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> results = result.getResults();

        System.out.printf("3개 일치 (5,000원) - %d개%n", results.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", results.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.get(Rank.FIRST));

        double profitRate = result.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}