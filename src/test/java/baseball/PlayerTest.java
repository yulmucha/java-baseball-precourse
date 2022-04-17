package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest extends NsTest {

    @Test
    void 숫자_선택_테스트() {
        assertSimpleTest(
                () -> {
                    run("246", "135", "937");
                    Player player = new Player();
                    System.out.println(player);
                    player.generateNums();
                    System.out.println(player);
                    player.generateNums();
                    System.out.println(player);
                    assertThat(output()).contains(
                            "숫자를 입력해주세요: |2|4|6|",
                            "숫자를 입력해주세요: |1|3|5|",
                            "숫자를 입력해주세요: |9|3|7|"
                    );
                }
        );
    }

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
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
