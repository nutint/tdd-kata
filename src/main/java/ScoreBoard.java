import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreBoard {
    private final String boardState;
    private final String firstPlayerScore;
    private final String secondPlayerScore;
}
