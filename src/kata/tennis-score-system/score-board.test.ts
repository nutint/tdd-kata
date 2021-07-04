import {BoardStatus, PlayerScore, ScoreBoard} from './score-board'

describe('ScoreBoard', () => {
  describe('constructor', () => {
    it('should start at 0 0 when the score board is created', () => {
      const actual = ScoreBoard()

      expect(actual.firstPlayerScore).toEqual(PlayerScore.Love)
      expect(actual.secondPlayerScore).toEqual(PlayerScore.Love)
    })

    it('should begin at not-started state', () => {
      const actual = ScoreBoard()

      expect(actual.boardStatus).toEqual('notStarted')
    })

    it('should start at 15 0 when specify first player score', () => {
      const actual = ScoreBoard(BoardStatus.Started, PlayerScore.Fifteen)

      expect(actual.firstPlayerScore).toEqual(PlayerScore.Fifteen)
      expect(actual.secondPlayerScore).toEqual(PlayerScore.Love)
    })

    it('should start at 15 15 when specify first player score', () => {
      const actual = ScoreBoard(BoardStatus.Started, PlayerScore.Fifteen, PlayerScore.Fifteen)

      expect(actual.firstPlayerScore).toEqual(PlayerScore.Fifteen)
      expect(actual.secondPlayerScore).toEqual(PlayerScore.Fifteen)
    })

    it('should be able to start at deuce state', () => {
      const actual = ScoreBoard(BoardStatus.Deuce)

      expect(actual.boardStatus).toEqual(BoardStatus.Deuce)
    })
  })
})
