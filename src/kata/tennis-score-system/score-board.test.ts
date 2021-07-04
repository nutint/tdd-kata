import {ScoreBoard} from './score-board'

describe('ScoreBoard', () => {
  describe('constructor', () => {
    it('should start at 0 0 when the score board is created', () => {
      const actual = ScoreBoard()

      expect(actual.firstPlayerScore).toEqual('0')
      expect(actual.secondPlayerScore).toEqual('0')
    })

    it('should start at 15 0 when specify first player score', () => {
      const actual = ScoreBoard('15')

      expect(actual.firstPlayerScore).toEqual('15')
      expect(actual.secondPlayerScore).toEqual('0')
    })

    it('should start at 15 15 when specify first player score', () => {
      const actual = ScoreBoard('15', '15')

      expect(actual.firstPlayerScore).toEqual('15')
      expect(actual.secondPlayerScore).toEqual('15')
    })
  })
})
