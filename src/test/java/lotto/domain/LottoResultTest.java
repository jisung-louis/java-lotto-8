package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void 로또_당첨결과_통계_계산() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)), // 6개 일치
                new Lotto(List.of(1,2,3,4,5,7)), // 5개+보너스
                new Lotto(List.of(1,2,3,4,5,8))  // 5개만 일치
        );
        WinningNumbers winning = new WinningNumbers("1,2,3,4,5,6", "7");
        LottoResult result = new LottoResult(lottos, winning);

        assertThat(result.getResults().get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getResults().get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getResults().get(Rank.THIRD)).isEqualTo(1);
    }
}