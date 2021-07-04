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
      initialFirstPlayerScore === PlayerScore.Love ? PlayerScore.Fifteen : PlayerScore.Thirty,
      initialSecondPlayerScore
    )
  });
}

export enum PlayerScore {
  Love = '0',
  Fifteen = '15',
  Thirty = '30',
}

export enum BoardStatus {
  NotStarted = 'notStarted',
  Started = 'started',
  Deuce = 'deuce'
}
