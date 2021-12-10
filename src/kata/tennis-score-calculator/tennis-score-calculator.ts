import {Score} from "./score";
import {PlayerId} from "./player-id";

export const incrementScore = (currentScore: Score) => {
  if(currentScore === Score.Love) return Score.Fifteen
  if(currentScore === Score.Fifteen) return Score.Thirty
  return Score.Forty
};

export const TennisScoreCalculator =
  (firstScore: Score = Score.Love, secondScore: Score = Score.Love) => ({
  firstPlayerScore: firstScore,
  secondPlayerScore: secondScore,
  playerDidScore: (playerId: PlayerId) => playerId == PlayerId.FirstPlayer
    ? TennisScoreCalculator(incrementScore(firstScore), Score.Love)
    : TennisScoreCalculator(Score.Love, incrementScore(secondScore))
})
