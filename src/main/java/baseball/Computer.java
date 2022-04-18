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
            nums[i] = pickNumber();
        }
    }

    private int pickNumber() {
        int num = Randoms.pickNumberInRange(Constants.NUMS_MIN, Constants.NUMS_MAX);
        while (isDuplicated(num)) {
            num = Randoms.pickNumberInRange(Constants.NUMS_MIN, Constants.NUMS_MAX);
        }

        return num;
    }

    private Boolean isDuplicated(int num) {
        for (int n : nums) {
            if (n == num) {
                return true;
            }
        }

        return false;
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
