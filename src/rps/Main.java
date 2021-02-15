package rps;

// Project imports
import rps.bll.game.Move;
import rps.bll.game.GameManager;
import rps.bll.player.AdvancedAiPlayer;
import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;

//Java imports
import java.util.Scanner;

public class Main {

    /**
     * Main start
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.print("Welcome to the classic Rock, Paper and Scissors game!");
        System.out.println();

        IPlayer human = new Player("Mr. Spangsberg", PlayerType.Human);
        IPlayer r2d2 = new AdvancedAiPlayer("AdvancedAIPlayer", PlayerType.AI);

        GameManager ge = new GameManager(human, r2d2);

        while (true) {
            String playerMove = getPlayerMove();

            if (playerMove.toLowerCase().equals("exit"))
                break;

            ge.playRound(Move.valueOf(playerMove));

            ge.getGameState().getHistoricResults().forEach((result) -> {
                System.out.println(result);
            });
        }
    }

    /**
     * Ask the human player to make a move...
     *
     * @return Rock, Paper or Scissor as String
     */
    public static String getPlayerMove() {
        Scanner keyboard = new Scanner(System.in);
        String input;
        boolean inputOK = false;

        do {
            inputOK = false;
            System.out.println();
            System.out.print("Choose Your Weapon (Rock, Paper or Scissor) or Exit to quit the game: ");
            input = keyboard.next();

            if ((input.toLowerCase().equals("rock")) || (input.toLowerCase().equals("paper")) ||
                (input.toLowerCase().equals("scissor")) || (input.toLowerCase().equals("exit"))) {
                inputOK = true;
            }
        }
        while (!inputOK);

        return input;
    }
}



