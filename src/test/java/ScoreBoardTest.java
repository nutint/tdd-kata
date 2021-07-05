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
        assertEquals(scoreBoard.getFirstPlayerScore(), 0);
        assertEquals(scoreBoard.getSecondPlayerScore(), 0);
    }

    @Test
    public void firstPlayerMakeFirstScore() {
        scoreBoard.firstPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), 1);
        assertEquals(scoreBoard.getSecondPlayerScore(), 0);
    }

    @Test
    public void firstPlayerMakeSecondScore() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), 2);
        assertEquals(scoreBoard.getSecondPlayerScore(), 0);
    }

    @Test
    public void firstPlayerMakeThirdScore() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), 3);
        assertEquals(scoreBoard.getSecondPlayerScore(), 0);
    }

    @Test
    public void secondPlayerMakeFirstScore() {
        scoreBoard.secondPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), 0);
        assertEquals(scoreBoard.getSecondPlayerScore(), 1);
    }

    @Test
    public void secondPlayerMakeSecondScore() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), 0);
        assertEquals(scoreBoard.getSecondPlayerScore(), 2);
    }

    @Test
    public void secondPlayerMakeThirdScore() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), 0);
        assertEquals(scoreBoard.getSecondPlayerScore(), 3);
    }
}
