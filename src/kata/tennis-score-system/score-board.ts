export const ScoreBoard = (boardStatus?: string, firstPlayerScore?: string, secondPlayerScore?: string) => ({
  boardStatus: boardStatus || 'notStarted',
  firstPlayerScore: firstPlayerScore || '0',
  secondPlayerScore: secondPlayerScore || '0'
})
