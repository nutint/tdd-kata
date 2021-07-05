import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    @BeforeEach
    public void initScoreBoard() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    @DisplayName("Start Game with 0-0")
    public void eachGameShouldStartWithInitialState() {
        assertEquals(scoreBoard.getBoardState(), BoardState.STARTED);
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
    }

    @Test
    @DisplayName("First player score 15-0")
    public void firstPlayerMakeFirstScore() {
        scoreBoard.firstPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.FIFTEEN);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("First player score 30-0")
    public void firstPlayerMakeSecondScore() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.THIRTY);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("First player score 40-0")
    public void firstPlayerMakeThirdScore() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.FORTY);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("Second player score 0-15")
    public void secondPlayerMakeFirstScore() {
        scoreBoard.secondPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.FIFTEEN);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("Second player score 0-30")
    public void secondPlayerMakeSecondScore() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.THIRTY);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("Second player score 0-40")
    public void secondPlayerMakeThirdScore() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.FORTY);
        assertEquals(BoardState.STARTED, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("First player win the game WIN-0")
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
    @DisplayName("Second player win the game 0-WIN")
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
    @DisplayName("Deuce 40-40")
    public void startingDeuce() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(Score.ZERO, scoreBoard.getFirstPlayerScore());
        assertEquals(Score.ZERO, scoreBoard.getSecondPlayerScore());
        assertEquals(BoardState.DEUCE, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("First player got advantage from Deuce 1-0")
    public void firstPlayerGotAdvantage() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();

        assertEquals(Score.ADVANTAGE, scoreBoard.getFirstPlayerScore());
        assertEquals(Score.ZERO, scoreBoard.getSecondPlayerScore());
        assertEquals(BoardState.ADVANTAGE, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("Second player got advantage from Deuce 0-1")
    public void secondPlayerGotAdvantage() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(Score.ZERO, scoreBoard.getFirstPlayerScore());
        assertEquals(Score.ADVANTAGE, scoreBoard.getSecondPlayerScore());
        assertEquals(BoardState.ADVANTAGE, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("Deuce again by second player")
    public void secondPlayerScoreDeuceAgain() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(Score.ZERO, scoreBoard.getFirstPlayerScore());
        assertEquals(Score.ZERO, scoreBoard.getSecondPlayerScore());
        assertEquals(BoardState.DEUCE, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("Deuce again by first player")
    public void firstPlayerScoreDeuceAgain() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        scoreBoard.secondPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();

        assertEquals(Score.ZERO, scoreBoard.getFirstPlayerScore());
        assertEquals(Score.ZERO, scoreBoard.getSecondPlayerScore());
        assertEquals(BoardState.DEUCE, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("First player win the Deuce")
    public void firstPlayerWinDeuce() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();

        assertEquals(Score.WIN_DEUCE, scoreBoard.getFirstPlayerScore());
        assertEquals(Score.ZERO, scoreBoard.getSecondPlayerScore());
        assertEquals(BoardState.FINISHED, scoreBoard.getBoardState());
    }

    @Test
    @DisplayName("Second player win the Deuce")
    public void secondPlayerWinDeuce() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();

        assertEquals(Score.ZERO, scoreBoard.getFirstPlayerScore());
        assertEquals(Score.WIN_DEUCE, scoreBoard.getSecondPlayerScore());
        assertEquals(BoardState.FINISHED, scoreBoard.getBoardState());
    }
}
