import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Score {
    LOVE(0, "0"),
    FIFTEEN(1, "15"),
    THIRTY(2, "30"),
    FORTY(3, "40"),
    WIN(4, "win"),
    ZERO(0, "zero"),
    ADVANTAGE(1, "advantage"),
    WIN_DEUCE(2, "win deuce"),
    OTHER(99, "NO VALUE");

    private final int point;
    private final String displayScore;

    public static Score findScore(int point) {
        for (Score score : Score.values()) {
            if (score.point == point) {
                return score;
            }
        }
        return OTHER;
    }

}
