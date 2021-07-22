import {PlayerScore} from "./player-score";
import {BoardStatus} from "./board-status";
import {increasePlayerScore} from "./increase-player-score";

export const ScoreBoard = (
  boardStatus?: BoardStatus,
  firstPlayerScore?: PlayerScore,
  secondPlayerScore?: PlayerScore
) => {
  const initialFirstPlayerScore = firstPlayerScore || PlayerScore.Love;
  const initialSecondPlayerScore = secondPlayerScore || PlayerScore.Love;
  return ({
    boardStatus: boardStatus || 'notStarted',
    firstPlayerScore: initialFirstPlayerScore,
    secondPlayerScore: initialSecondPlayerScore,
    firstPlayerMakeThePoint: () => {
      if(initialFirstPlayerScore === PlayerScore.Thirty && initialSecondPlayerScore === PlayerScore.Forty) {
        return ScoreBoard(
          BoardStatus.Deuce
        )
      }
      return ScoreBoard(
        BoardStatus.Started,
        increasePlayerScore(initialFirstPlayerScore),
        initialSecondPlayerScore
      )
    },
    secondPlayerMakeThePoint: () => {
      if(initialFirstPlayerScore === PlayerScore.Forty && initialSecondPlayerScore === PlayerScore.Thirty) {
        return ScoreBoard(
          BoardStatus.Deuce
        )
      }
      return ScoreBoard(
        BoardStatus.Started,
        initialFirstPlayerScore,
        increasePlayerScore(initialSecondPlayerScore)
      )
    },
  });
}

