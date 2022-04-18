package baseball;

public class Referee {

    public int getStrikeCount(int[] computerNums, int[] playerNums) {
        int count = 0;
        for (int i = 0; i < Constants.NUMS_SIZE; i++) {
            count += isSame(computerNums[i], playerNums[i]);
        }

        return count;
    }

    public int getBallCount(int[] computerNums, int[] playerNums) {
        int count = 0;
        for (int i = 0; i < playerNums.length; i++) {
            count += getSingleBallCount(computerNums, i, playerNums[i]);
        }

        return count;
    }

    public int getSingleBallCount(int[] computerNums, int index, int playerNum) {
        int count = 0;
        for (int j = 0; j < index; j++) {
            count += isSame(computerNums[j], playerNum);
        }
        for (int j = index + 1; j < computerNums.length; j++) {
            count += isSame(computerNums[j], playerNum);
        }

        return count;
    }

    private int isSame(int a, int b) {
        if (a == b) {
            return 1;
        }

        return 0;
    }
}
