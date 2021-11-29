import {Score} from "./score";

export const TennisScoreCalculator =
  (firstScore: Score = Score.Love, secondScore: Score = Score.Love) => ({
  firstPlayerScore: firstScore,
  secondPlayerScore: secondScore,
  playerDidScore: (playerId: string) => TennisScoreCalculator(Score.Fifteen, Score.Love)
})
