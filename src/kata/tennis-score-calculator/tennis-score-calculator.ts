import {Score} from "./score";
import {PlayerId} from "./player-id";

export const TennisScoreCalculator =
  (firstScore: Score = Score.Love, secondScore: Score = Score.Love) => ({
  firstPlayerScore: firstScore,
  secondPlayerScore: secondScore,
  playerDidScore: (playerId: PlayerId) => playerId == PlayerId.FirstPlayer
    ? TennisScoreCalculator(Score.Fifteen, Score.Love)
    : TennisScoreCalculator(Score.Love, Score.Fifteen)
})
