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

      expect(actual.boardStatus).toEqual(BoardStatus.NotStarted)
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

  describe('xPlayerMakeThePoint', () => {
    it('started at 0-0, when first player make the point should become 15-0', () => {
      const actual = ScoreBoard().firstPlayerMakeThePoint()

      expect(actual.firstPlayerScore).toEqual(PlayerScore.Fifteen)
      expect(actual.secondPlayerScore).toEqual(PlayerScore.Love)
    })

    it('started at 0-0, when first player make the point should have status started', () => {
      const actual = ScoreBoard().firstPlayerMakeThePoint()

      expect(actual.boardStatus).toEqual(BoardStatus.Started)
    })

    it('started at 0-0, when first player make the point 2 times should become 30-0', () => {
      const actual = ScoreBoard()
        .firstPlayerMakeThePoint()
        .firstPlayerMakeThePoint()

      expect(actual.firstPlayerScore).toEqual(PlayerScore.Thirty)
      expect(actual.secondPlayerScore).toEqual(PlayerScore.Love)
    })
  })
})
