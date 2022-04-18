package baseball;

public class Application {
    public static void main(String[] args) {
        GameController game = new GameController(new Computer(), new Player(), new Referee());
        game.run();
    }
}
