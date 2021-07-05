import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    @BeforeEach
    public void initScoreBoard() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    public void eachGameShouldStartWithInitialState() {
        assertEquals(scoreBoard.getBoardState(), BoardState.STARTED);
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
    }

    @Test
    public void firstPlayerMakeFirstScore() {
        scoreBoard.firstPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.FIFTEEN);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    public void firstPlayerMakeSecondScore() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.THIRTY);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    public void firstPlayerMakeThirdScore() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.FORTY);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    public void secondPlayerMakeFirstScore() {
        scoreBoard.secondPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.FIFTEEN);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    public void secondPlayerMakeSecondScore() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.THIRTY);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    public void secondPlayerMakeThirdScore() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.FORTY);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    public void firstPlayerWinTheGame() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.WIN);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
        assertEquals(BoardState.FINISHED, scoreBoard.getBoardState());
    }

    @Test
    public void secondPlayerWinTheGame() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.WIN);
        assertEquals(BoardState.FINISHED, scoreBoard.getBoardState());
    }

    @Test
    public void startingDeuce() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), scoreBoard.getSecondPlayerScore());
        assertEquals(BoardState.DEUCE, scoreBoard.getBoardState());
    }
}
