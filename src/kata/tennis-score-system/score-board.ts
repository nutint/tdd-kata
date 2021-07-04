
function increasePlayerScore(initialFirstPlayerScore: PlayerScore) {
  switch (initialFirstPlayerScore) {
    case PlayerScore.Love:
      return PlayerScore.Fifteen;
    case PlayerScore.Fifteen:
      return PlayerScore.Thirty;
    default:
      return PlayerScore.Forty;
  }
}

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
    firstPlayerMakeThePoint: () => ScoreBoard(
      BoardStatus.Started,
      increasePlayerScore(initialFirstPlayerScore),
      initialSecondPlayerScore
    ),
    secondPlayerMakeThePoint: () => ScoreBoard(
      BoardStatus.Started,
      initialFirstPlayerScore,
      increasePlayerScore(initialSecondPlayerScore)
    ),
  });
}

export enum PlayerScore {
  Love = '0',
  Fifteen = '15',
  Thirty = '30',
  Forty = '40',
}

export enum BoardStatus {
  NotStarted = 'notStarted',
  Started = 'started',
  Deuce = 'deuce'
}
