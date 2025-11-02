package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    void 당첨번호가_6개가_아니면_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @Test
    void 당첨번호와_보너스번호가_중복되면_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }
}