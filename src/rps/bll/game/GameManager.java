package rps.bll.game;

//Java imports
import java.util.ArrayList;

//Project imports
import rps.bll.player.IPlayer;

/**
 *
 */
public class GameManager {

    private IGameState gameState;
    private IPlayer bot;
    private IPlayer human;

    /**
     * Initializes the GameManager with IPlayers
     * Game expected to be played Human vs Bot
     * @param human
     * @param bot
     */
    public GameManager(IPlayer human, IPlayer bot) {
        gameState = new GameState(new ArrayList<>(), 1);
        this.human = human;
        this.bot = bot;
    }

    /**
     * User input driven Update
     *
     * @param human_move The next user move
     */
    public Result playRound(Move human_move) {
        Move bot_move = bot.doMove(gameState); //ask the bot to make a move...
        Result result;
        int roundNumber = gameState.getRoundNumber();

        //Rules
        if (human_move == bot_move)
            result = new Result(human, human_move, bot, bot_move, ResultStatus.Tie, roundNumber);
        else if ((human_move == Move.Rock && bot_move == Move.Scissor) ||
                (human_move == Move.Scissor && bot_move == Move.Paper) ||
                (human_move == Move.Paper && bot_move == Move.Rock)) {
            result = new Result(human, human_move, bot, bot_move, ResultStatus.Win, roundNumber);
        } else {
            result = new Result(bot, bot_move, human, human_move, ResultStatus.Win, roundNumber);
        }

        gameState.setRoundNumber(++roundNumber);
        gameState.getHistoricResults().add(result);

        return result;
    }

    /**
     *
     * @return
     */
    public IGameState getGameState() {
        return gameState;
    }
}
