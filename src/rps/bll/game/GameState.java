package rps.bll.game;

//Project imports

//Java imports
import java.util.ArrayList;

public class GameState implements IGameState {

    private ArrayList<Result> historicMoves;
    private int roundNumber;


    public GameState(ArrayList<Result> historicMoves, int roundNumber) {
        this.historicMoves = new ArrayList<>();
        this.roundNumber = roundNumber;
    }

    @Override
    public int getRoundNumber() {
        return roundNumber;
    }

    @Override
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    @Override
    public ArrayList<Result> getHistoricResults() {
        return historicMoves;
    }
}
