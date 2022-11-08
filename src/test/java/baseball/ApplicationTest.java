package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("유저 입력에 중복이 없는지 테스트")
    void checkDuplicate() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("118"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("유저 입력에 공백이 포함되어 있는지 테스트")
    void checkSpace() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("유저 입력에 숫자가 아닌것이 있는지 테스트")
    void checkNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2!3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("재시작 커맨드에 예상치 못한 입력 예외처리 테스트")
    void checkRestartCommend() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("246", "135", "1", "597", "589", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
