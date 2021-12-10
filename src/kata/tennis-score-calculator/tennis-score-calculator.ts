import {Score} from "./score";
import {PlayerId} from "./player-id";

export const incrementScore = (currentScore: Score) => {
  if(currentScore === Score.Love) return Score.Fifteen
  if(currentScore === Score.Fifteen) return Score.Thirty
  return Score.Forty
};

export const TennisScoreCalculator = (
  firstScore: Score = Score.Love,
  secondScore: Score = Score.Love,
  winner: PlayerId = PlayerId.NoPlayer) => ({
  firstPlayerScore: firstScore,
  secondPlayerScore: secondScore,
  winner,
  deuce: firstScore === Score.Forty && secondScore == Score.Forty,
  playerDidScore: (playerId: PlayerId) => {
    if(playerId === PlayerId.FirstPlayer) {
      return TennisScoreCalculator(incrementScore(firstScore), secondScore)
    }
    return secondScore !== Score.Forty
      ? TennisScoreCalculator(firstScore, incrementScore(secondScore))
      : TennisScoreCalculator(Score.Love, Score.Love, PlayerId.SecondPlayer)
  }
})
