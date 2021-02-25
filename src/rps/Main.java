package rps;

import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;
import rps.gui.ConsoleApp;
import rps.gui.JavaFXApp;

public class Main {

    /**
     * Main start
     * @param args
     */
    public static void main(String[] args)
    {
        //Console version
        //startRPSConsoleGame();

        //GUI version
        startRPSJavaFXGame();
    }


    /**
     * Start the GUI (JavaFX) version of the game
     */
    private static void startRPSJavaFXGame() {
        JavaFXApp.launch();
    }


    /**
     * Start a console version of the game
     */
    public static void startRPSConsoleGame() {
        IPlayer human = new Player("Luke Skywalker", PlayerType.Human);
        IPlayer r2d2 = new Player("R2D2", PlayerType.AI);

        ConsoleApp c = new ConsoleApp(human, r2d2);
        c.runGame();
    }
}



