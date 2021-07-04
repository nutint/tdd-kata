import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {


    @Test
    public void eachGameShouldStartWithInitialState() {
        ScoreBoard scoreBoard = new ScoreBoard("NotStarted", "0", "0");
        assertEquals(scoreBoard.getBoardState(), "NotStarted");
        assertEquals(scoreBoard.getFirstPlayerScore(), "0");
        assertEquals(scoreBoard.getSecondPlayerScore(), "0");
    }
}
