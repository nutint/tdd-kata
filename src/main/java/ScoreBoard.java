public class ScoreBoard {
    private String boardState;
    private Score firstPlayerScore;
    private Score secondPlayerScore;

    ScoreBoard() {
        this.boardState = BoardState.STARTED;
        this.firstPlayerScore = Score.LOVE;
        this.secondPlayerScore = Score.LOVE;
    }

    public String getBoardState() {
        return boardState;
    }

    public Score getFirstPlayerScore() {
        return this.firstPlayerScore;
    }

    public Score getSecondPlayerScore() {
        return this.secondPlayerScore;
    }

    public void firstPlayerMakeScore() {
        switch (this.firstPlayerScore) {
            case LOVE:
                this.firstPlayerScore = Score.FIFTEEN;
                break;
            case FIFTEEN:
                this.firstPlayerScore = Score.THIRTY;
                break;
            case THIRTY:
                this.firstPlayerScore = Score.FORTY;
                if (this.firstPlayerScore == this.secondPlayerScore) {
                    this.boardState = BoardState.DEUCE;
                    this.firstPlayerScore = Score.ZERO;
                    this.secondPlayerScore = Score.ZERO;
                }
                break;
            case FORTY:
                if (Math.abs(this.firstPlayerScore.getPoint() - this.secondPlayerScore.getPoint()) >= 2) {
                    this.boardState = BoardState.FINISHED;
                    this.firstPlayerScore = Score.WIN;
                }
                break;
            case ZERO:
                this.boardState = BoardState.ADVANTAGE;
                this.firstPlayerScore = Score.ADVANTAGE;
                break;
        }
    }

    public void secondPlayerMakeScore() {
        switch (this.secondPlayerScore) {
            case LOVE:
                this.secondPlayerScore = Score.FIFTEEN;
                break;
            case FIFTEEN:
                this.secondPlayerScore = Score.THIRTY;
                break;
            case THIRTY:
                this.secondPlayerScore = Score.FORTY;
                if (this.firstPlayerScore == this.secondPlayerScore) {
                    this.boardState = BoardState.DEUCE;
                    this.firstPlayerScore = Score.ZERO;
                    this.secondPlayerScore = Score.ZERO;
                }
                break;
            case FORTY:
                if (Math.abs(this.firstPlayerScore.getPoint() - this.secondPlayerScore.getPoint()) >= 2) {
                    this.boardState = BoardState.FINISHED;
                    this.secondPlayerScore = Score.WIN;
                }
                break;
            case ZERO:
                this.boardState = BoardState.ADVANTAGE;
                this.secondPlayerScore = Score.ADVANTAGE;
                break;
        }
    }
}
