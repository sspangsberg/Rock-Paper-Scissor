package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;

//Java imports
import java.util.Random;


public class Player implements IPlayer {

    private String name;
    private PlayerType type;

    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public PlayerType getPlayerType() {
        return type;
    }


    /**
     *
     * @param state
     * @return
     */
    @Override
    public Move doMove(IGameState state) {
        //Implement some fancy advanced AI here...
        Random random = new Random();
        return Move.values()[random.nextInt(Move.values().length)];
    }
}
