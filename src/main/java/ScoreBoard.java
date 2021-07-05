public class ScoreBoard {
    private String boardState;
    private int firstPlayerScore;
    private int secondPlayerScore;

    ScoreBoard() {
        this.boardState = BoardState.STARTED;
        this.firstPlayerScore = Score.LOVE.getPoint();
        this.secondPlayerScore = Score.LOVE.getPoint();
    }

    public String getBoardState() {
        return boardState;
    }

    public Score getFirstPlayerScore() {
        return Score.findScore(firstPlayerScore);
    }

    public Score getSecondPlayerScore() {
        return Score.findScore(secondPlayerScore);
    }

    public void firstPlayerMakeScore() {
        this.firstPlayerScore++;

        if (this.firstPlayerScore == Score.FORTY.getPoint() && this.firstPlayerScore == this.secondPlayerScore) {
            this.boardState = BoardState.DEUCE;
        }

        if (this.firstPlayerScore > Score.FORTY.getPoint() && this.firstPlayerScore - this.secondPlayerScore >= 2) {
            this.firstPlayerScore = Score.WIN.getPoint();
            this.boardState = BoardState.FINISHED;
        }
    }

    public void secondPlayerMakeScore() {
        this.secondPlayerScore++;

        if (this.secondPlayerScore == Score.FORTY.getPoint() && this.secondPlayerScore == this.firstPlayerScore) {
            this.boardState = BoardState.DEUCE;
        }

        if (this.secondPlayerScore > Score.FORTY.getPoint() && this.secondPlayerScore - this.firstPlayerScore >= 2) {
            this.secondPlayerScore = Score.WIN.getPoint();
            this.boardState = BoardState.FINISHED;
        }
    }
}
