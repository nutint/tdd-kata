import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ScoreBoard {
    private String boardState;
    private int firstPlayerScore;
    private int secondPlayerScore;

    ScoreBoard() {
        this.boardState = "started";
        this.firstPlayerScore = 0;
        this.secondPlayerScore = 0;
    }

    public void firstPlayerMakeScore() {
        this.firstPlayerScore++;
    }

    public void secondPlayerMakeScore() {
        this.secondPlayerScore++;
    }
}
