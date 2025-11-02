package lotto.domain;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumbers);
            results.put(rank, results.get(rank) + 1);
        }
    }

    private Rank calculateRank(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getWinningNumbers().contains(number)) {
                matchCount++;
            }
        }
        boolean matchBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
        return Rank.findRank(matchCount, matchBonus);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0; // 소수점 둘째 자리 반올림
    }
}