package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player implements GamePlayer {

    private int[] nums = new int[Constants.NUMS_SIZE];

    @Override
    public int[] getNums() {
        return nums;
    }

    public Player() {
        generateNums();
    }

    @Override
    public void generateNums() {
        String[] split = getInput().split("");
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
    }

    private String getInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();

        if (!isValidInput(input)) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }

        return input;
    }

    private Boolean isValidInput(String input) {
        if (input.length() != Constants.NUMS_SIZE) {
            return false;
        }

        String[] split = input.split("");

        if (isDuplicated(split)) {
            return false;
        }

        if (!isInRange(split)) {
            return false;
        }

        return true;
    }

    private Boolean isDuplicated(String[] numsStr) {
        for (String numStr : numsStr) {
            if (isDuplicated(numStr, numsStr)) {
                return true;
            }
        }

        return false;
    }

    private Boolean isDuplicated(String numStr, String[] numsStr) {
        int count = 0;
        for (String n : numsStr) {
            if (numStr.equals(n)) {
                count++;
            }
        }

        if (count > 1) {
            return true;
        }

        return false;
    }

    private Boolean isInRange(String[] numsStr) {
        for (String numStr : numsStr) {
            int num = Integer.parseInt(numStr);
            if (num < 1 || num > 9) {
                return false;
            }
        }

        return true;
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
