package rps.bll.game;

import java.util.ArrayList;

public interface IGameState {

    /**
     * Gets the round number in the game
     * @return
     */
    int getRoundNumber();

    /**
     * Sets the round number in the game
     * @param roundNumber
     */
    void setRoundNumber(int roundNumber);


    /**
     * Returns a list of the previous Results in the game
     * @return
     */
    ArrayList<Result> getHistoricResults();
}
