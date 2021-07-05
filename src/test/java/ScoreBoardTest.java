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
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
    }

    @Test
    public void firstPlayerMakeFirstScore() {
        scoreBoard.firstPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.FIFTEEN);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
    }

    @Test
    public void firstPlayerMakeSecondScore() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.THIRTY);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
    }

    @Test
    public void firstPlayerMakeThirdScore() {
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        scoreBoard.firstPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.FORTY);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.LOVE);
    }

    @Test
    public void secondPlayerMakeFirstScore() {
        scoreBoard.secondPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.FIFTEEN);
    }

    @Test
    public void secondPlayerMakeSecondScore() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.THIRTY);
    }

    @Test
    public void secondPlayerMakeThirdScore() {
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        scoreBoard.secondPlayerMakeScore();
        assertEquals(scoreBoard.getFirstPlayerScore(), Score.LOVE);
        assertEquals(scoreBoard.getSecondPlayerScore(), Score.FORTY);
    }
}
