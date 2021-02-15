package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.util.ArrayList;

public class AdvancedAiPlayer implements IPlayer {

    private String name;
    private PlayerType type;

    public AdvancedAiPlayer(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public PlayerType getPlayerType() {
        return type;
    }

    @Override
    public Move doMove(IGameState state) {

        ArrayList<Result> results = state.getHistoricResults();
        ArrayList<Move> humanMoves = new ArrayList<>();


        for (int i=0; i< results.size(); i++)
        {
            if (results.get(i).getLoserPlayer().getPlayerType() == PlayerType.Human)
                humanMoves.add(results.get(i).getLoserMove());
            else
                humanMoves.add(results.get(i).getWinnerMove());
        }

        return Move.Rock;
    }
}
