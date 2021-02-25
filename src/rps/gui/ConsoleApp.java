package rps.gui;

// Project imports

import rps.bll.game.GameManager;
import rps.bll.game.Move;
import rps.bll.game.Result;
import rps.bll.game.ResultStatus;
import rps.bll.player.IPlayer;

// Java imports
import java.util.Scanner;

public class ConsoleApp {

    IPlayer human;
    IPlayer bot;

    public ConsoleApp(IPlayer human, IPlayer bot) {
        this.human = human;
        this.bot = bot;
    }

    public void runGame() {
        System.out.println("Welcome to the classic Rock, Paper and Scissors game!");

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
