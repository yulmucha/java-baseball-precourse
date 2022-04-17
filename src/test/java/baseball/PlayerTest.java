package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest extends NsTest {

    @Test
    void 예외_테스트() {
        assertSimpleTest(
                () -> {
                    assertThatThrownBy(() -> {
                        run("109");
                        Player player = new Player();
                    }).isInstanceOf(IllegalArgumentException.class);

                    assertThatThrownBy(() -> {
                        run("1234");
                        Player player = new Player();
                    }).isInstanceOf(IllegalArgumentException.class);

                    assertThatThrownBy(() -> {
                        run("122");
                        Player player = new Player();
                    }).isInstanceOf(IllegalArgumentException.class);

                    assertThatThrownBy(() -> {
                        run("1!2");
                        Player player = new Player();
                    }).isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
