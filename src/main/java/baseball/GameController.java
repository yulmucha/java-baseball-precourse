package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private int ballCount = 0;
    private int strikeCount = 0;
    private final GamePlayer computer;
    private final GamePlayer player;
    private final Referee referee;

    public GameController(Computer computer, GamePlayer player, Referee referee) {
        this.computer = computer;
        this.player = player;
        this.referee = referee;
    }

    public void run() {
        while (true) {
            compareNums();
            printResult();

            if (!isEnd()) {
                player.generateNums();
                continue;
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");

            String input = getRestartOrEndInput();

            if (input.equals("1")) {
                computer.generateNums();
                player.generateNums();
                continue;
            }

            if (input.equals("2")) {
                System.out.println("게임 종료");
                break;
            }
        }
    }

    private String getRestartOrEndInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (!isValidRestartOrEndInput(input)) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }

        return input;
    }

    private Boolean isValidRestartOrEndInput(String input) {
        if (input.length() > 1 || !(input.equals("1") || input.equals("2"))) {
            return false;
        }

        return true;
    }

    private void compareNums() {
        ballCount = referee.getBallCount(computer.getNums(), player.getNums());
        strikeCount = referee.getStrikeCount(computer.getNums(), player.getNums());
    }

    private Boolean isEnd() {
        if (strikeCount == 3) {
            return true;
        }

        return false;
    }

    private void printResult() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }

        if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
            return;
        }

        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        return;
    }
}
