package rps.gui;

// Project imports
import rps.bll.game.*;
import rps.bll.player.*;

// Java imports
import java.util.Random;
import java.util.Scanner;

/**
 * Console implementation of the RPS game
 *
 * @author smsj
 */
public class ConsoleApp {

    /**
     * Starts the game
     */
    public void startGame() {
        System.out.println("Welcome to the classic Rock, Paper and Scissors game!");
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please type in your player name: ");
        String playerName = keyboard.next();

        IPlayer human = new Player(playerName, PlayerType.Human);
        IPlayer bot = new Player(getRandomBotName(), PlayerType.AI);

        System.out.println("Your opponent is " + bot.getPlayerName());
        System.out.println("Starting game.... good luck both!");

        GameManager ge = new GameManager(human, bot);

        while (true) {
            String playerMove = getPlayerMove();

            if (playerMove.toLowerCase().equals("exit"))
                break;

            ge.playRound(Move.valueOf(playerMove));
            ge.getGameState().getHistoricResults().forEach((result) -> {
                System.out.println(getResultAsString(result));
            });
        }

        if (ge.getGameState().getHistoricResults().size() > 0)
            System.out.println("Game stats: ....ehmmmm..not implemented yet...please FIXME");
    }


    /**
     * Famous robots...
     * @return
     */
    private String getRandomBotName() {
        String[] botNames = new String[] {
                "R2D2",
                "Mr. Data",
                "3PO",
                "Bender",
                "Marvin the Paranoid Android",
                "Bishop",
                "Robot B-9",
                "HAL"
        };
        int randomNumber = new Random().nextInt(botNames.length - 1);
        return botNames[randomNumber];
    }


    /**
     * Ask the human player to make a move...
     *
     * @return Rock, Paper or Scissor as String
     */
    public String getPlayerMove() {
        Scanner keyboard = new Scanner(System.in);
        String input;
        boolean inputOK = false;

        do {
            inputOK = false;
            System.out.println();
            System.out.print("Choose Your Weapon (Rock/R, Paper/P or Scissor/S) or Exit/E to quit the game: ");
            input = keyboard.next();

            if (input.toLowerCase().equals("rock") || input.toLowerCase().equals("r") ||
                input.toLowerCase().equals("paper") || input.toLowerCase().equals("p") ||
                input.toLowerCase().equals("scissor") || input.toLowerCase().equals("s") ||
                input.toLowerCase().equals("exit") || input.toLowerCase().equals("e")) {
                inputOK = true;

                if (input.toLowerCase().equals("r")) { input = "Rock"; }
                else if (input.toLowerCase().equals("p")) { input = "Paper"; }
                else if (input.toLowerCase().equals("s")) { input = "Scissor"; }
                else if (input.toLowerCase().equals("e")) { input = "Exit"; }
            }
            else { System.out.println("Invalid input. Try again :)"); }
        }
        while (!inputOK);

        return input;
    }

    /**
     * @param result
     * @return
     */
    public String getResultAsString(Result result) {
        String statusText = result.getStatus() == ResultStatus.Win ? "wins over " : "ties ";

        return "Round #" + result.getRoundNumber() + ":" +
                result.getWinnerPlayer().getPlayerName() +
                " (" + result.getWinnerMove() + ") " +
                statusText + result.getLoserPlayer().getPlayerName() +
                " (" + result.getLoserMove() + ")!";
    }
}
