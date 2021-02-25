package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;

public interface IPlayer {

    /**
     * Returns the name of the player
     * @return
     */
    public String getPlayerName();


    /**
     * Returns the type of the player (AI or Human)
     * @return
     */
    public PlayerType getPlayerType();


    /**
     * Make a Move (Rock, Paper or Scissor)
     *
     * @return
     * @param state
     */
    public Move doMove(IGameState state);
}
