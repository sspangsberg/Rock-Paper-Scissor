package rps.bll.game;

import rps.bll.player.IPlayer;

public class Result {

    private ResultStatus status;
    private Move winnerMove;
    private IPlayer winnerPlayer;
    private Move loserMove;
    private IPlayer loserPlayer;
    private int roundNumber;

    /**
     * Initializes a new Result with a winner, loser and their moves
     * @param winnerPlayer
     * @param winnerMove
     * @param loserPlayer
     * @param loserMove
     * @param status
     * @param roundNumber
     */
    public Result(IPlayer winnerPlayer, Move winnerMove, IPlayer loserPlayer, Move loserMove, ResultStatus status, int roundNumber) {
        this.winnerPlayer = winnerPlayer;
        this.winnerMove = winnerMove;
        this.loserPlayer = loserPlayer;
        this.loserMove = loserMove;
        this.status = status;
        this.roundNumber = roundNumber;
    }

    public Move getWinnerMove() {
        return winnerMove;
    }

    public IPlayer getWinnerPlayer() {
        return winnerPlayer;
    }

    public Move getLoserMove() {
        return loserMove;
    }

    public IPlayer getLoserPlayer() {
        return loserPlayer;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    @Override
    public String toString() {
        String statusText = status == ResultStatus.Win ? "wins over " : "ties ";

        return "Round #" + roundNumber + ":" + winnerPlayer.getPlayerName() + " (" + winnerMove + ") " + statusText + loserPlayer.getPlayerName() + " (" + loserMove + ")!";
    }
}
