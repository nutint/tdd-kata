export const ScoreBoard = (
  boardStatus?: BoardStatus,
  firstPlayerScore?: PlayerScore,
  secondPlayerScore?: PlayerScore
) => ({
  boardStatus: boardStatus || 'notStarted',
  firstPlayerScore: firstPlayerScore || '0',
  secondPlayerScore: secondPlayerScore || '0'
})

export enum PlayerScore {
  Love = '0',
  Fifteen = '15'
}

export enum BoardStatus {
  Started = 'started',
  Deuce = 'deuce'
}
