package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest extends NsTest {

    Computer computer = new Computer();

    @Test
    void 숫자_선택_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    computer.generateNums();
                    System.out.println(computer);
                    assertThat(output()).contains("|1|3|5|");
                    computer.generateNums();
                    System.out.println(computer);
                    assertThat(output()).contains("|3|5|1|");
                },
                1, 3, 1, 3, 5, 3, 5, 1
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
