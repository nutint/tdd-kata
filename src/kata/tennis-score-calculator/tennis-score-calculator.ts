import {Score} from "./score";
import {PlayerId} from "./player-id";

const incrementScore = (currentScore: Score) =>
  currentScore === Score.Love ? Score.Fifteen : Score.Thirty;

export const TennisScoreCalculator =
  (firstScore: Score = Score.Love, secondScore: Score = Score.Love) => ({
  firstPlayerScore: firstScore,
  secondPlayerScore: secondScore,
  playerDidScore: (playerId: PlayerId) => playerId == PlayerId.FirstPlayer
    ? TennisScoreCalculator(incrementScore(firstScore), Score.Love)
    : TennisScoreCalculator(Score.Love, incrementScore(secondScore))
})
