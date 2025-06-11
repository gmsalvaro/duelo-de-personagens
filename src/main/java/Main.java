import game.gameController;

public class Main {
    //Executar via terminal: java -jar target/Duelo-de-personagens-1.0-SNAPSHOT.jar
    public static void main(String[] args) {
        gameController game = new gameController();
        game.start();
    }
}