package rps.bll.game;

//Java imports
import java.util.Collection;

/**
 * Interface definition for the RPS game state
 *
 * @author smsj
 */
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
     * Returns a collection of the previous Results in the game
     * @return
     */
    Collection<Result> getHistoricResults();
}
