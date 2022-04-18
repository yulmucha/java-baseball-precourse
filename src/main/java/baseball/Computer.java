package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer implements GamePlayer {

    private int[] nums = new int[Constants.NUMS_SIZE];

    @Override
    public int[] getNums() {
        return nums;
    }

    @Override
    public void generateNums() {
        clearNums();

        for (int i = 0; i < Constants.NUMS_SIZE; i++) {
            nums[i] = pickNumber(i);
        }
    }

    private int pickNumber(int i) {
        int num = Randoms.pickNumberInRange(Constants.NUMS_MIN, Constants.NUMS_MAX);
        while (isDuplicated(num, i)) {
            num = Randoms.pickNumberInRange(Constants.NUMS_MIN, Constants.NUMS_MAX);
        }

        return num;
    }

    private Boolean isDuplicated(int num, int index) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            count += isSame(nums[i], num);
        }

        if (count == 0) {
            return false;
        }

        return true;
    }

    private int isSame(int a, int b) {
        if (a == b) {
            return 1;
        }

        return 0;
    }

    private void clearNums() {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Constants.NUMS_MIN - 1;
        }
    }

    @Override
    public String toString() {
        String numsStr = "|";
        for (int i = 0; i < Constants.NUMS_SIZE; i++) {
            numsStr += nums[i];
            numsStr += "|";
        }
        return numsStr;
    }
}
