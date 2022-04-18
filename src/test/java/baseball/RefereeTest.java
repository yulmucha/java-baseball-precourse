package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    Referee referee = new Referee();

    @Test
    void 스트라이크_테스트() {
        int[] computerNums = {1, 4, 5};
        int[][] playerNumsSet = {
                {3, 4, 1},
                {1, 2, 5},
                {1, 4, 5}
        };

        int strikeCount = referee.getStrikeCount(computerNums, playerNumsSet[0]);
        Assertions.assertThat(strikeCount).isEqualTo(1);

        strikeCount = referee.getStrikeCount(computerNums, playerNumsSet[1]);
        Assertions.assertThat(strikeCount).isEqualTo(2);

        strikeCount = referee.getStrikeCount(computerNums, playerNumsSet[2]);
        Assertions.assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    void 볼_테스트_1() {
        int[] computerNums = {1, 4, 5};
        int[] playerNums = {3, 4, 1};

        int index = 0;
        int singleBallCount = referee.getSingleBallCount(computerNums, index, playerNums[index]);
        Assertions.assertThat(singleBallCount).isEqualTo(0);

        index = 1;
        singleBallCount = referee.getSingleBallCount(computerNums, index, playerNums[index]);
        Assertions.assertThat(singleBallCount).isEqualTo(0);

        index = 2;
        singleBallCount = referee.getSingleBallCount(computerNums, index, playerNums[index]);
        Assertions.assertThat(singleBallCount).isEqualTo(1);
    }

    @Test
    void 볼_테스트_2() {
        int[] computerNums = {1, 4, 5};
        int[][] playerNumsSet = {
                {3, 4, 1},
                {5, 4, 1},
                {2, 3, 6},
                {1, 4, 5},
        };

        int ballCount = referee.getBallCount(computerNums, playerNumsSet[0]);
        Assertions.assertThat(ballCount).isEqualTo(1);

        ballCount = referee.getBallCount(computerNums, playerNumsSet[1]);
        Assertions.assertThat(ballCount).isEqualTo(2);

        ballCount = referee.getBallCount(computerNums, playerNumsSet[2]);
        Assertions.assertThat(ballCount).isEqualTo(0);

        ballCount = referee.getBallCount(computerNums, playerNumsSet[3]);
        Assertions.assertThat(ballCount).isEqualTo(0);
    }
}
