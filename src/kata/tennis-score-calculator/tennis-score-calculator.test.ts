import {TennisScoreCalculator} from './tennis-score-calculator'
import {Score} from "./score";
import {PlayerId} from "./player-id";

describe("TennisScoreCalculator", () => {

  describe("initialization", () => {
    it("should not throw during initialization", () => {
      expect(() => TennisScoreCalculator()).not.toThrow()
    })

    it("should start with first and second player score `love - love`", () => {
      const tennisScoreCalculator = TennisScoreCalculator();

      expect(tennisScoreCalculator.firstPlayerScore).toEqual(Score.Love)
      expect(tennisScoreCalculator.secondPlayerScore).toEqual(Score.Love)
    })

    it("should be able to initialize the initial score", () => {
      const tennisScoreCalculator = TennisScoreCalculator(Score.Fifteen, Score.Love);

      expect(tennisScoreCalculator.firstPlayerScore).toEqual(Score.Fifteen)
      expect(tennisScoreCalculator.secondPlayerScore).toEqual(Score.Love)
    })
  })

  describe("playerDidScore", () => {
    it("start from love-love then first player score, should become 15-love", () => {
      const newScoreCalculator = TennisScoreCalculator()
        .playerDidScore(PlayerId.FirstPlayer)

      expect(newScoreCalculator.firstPlayerScore).toEqual(Score.Fifteen)
      expect(newScoreCalculator.secondPlayerScore).toEqual(Score.Love)
    })

    it("start from love-love then second player score, should become love-15", () => {
      const newScoreCalculator = TennisScoreCalculator()
        .playerDidScore(PlayerId.SecondPlayer)

      expect(newScoreCalculator.firstPlayerScore).toEqual(Score.Love)
      expect(newScoreCalculator.secondPlayerScore).toEqual(Score.Fifteen)
    })

    it("start from fifteen-love then first player score, should become thirty-love", () => {
      const newScoreCalculator = TennisScoreCalculator(Score.Fifteen, Score.Love)
        .playerDidScore(PlayerId.FirstPlayer)

      expect(newScoreCalculator.firstPlayerScore).toEqual(Score.Thirty)
      expect(newScoreCalculator.secondPlayerScore).toEqual(Score.Love)
    })

    it("start from love-fifteen then second player score, should become love-thirty", () => {
      const newScoreCalculator = TennisScoreCalculator(Score.Love, Score.Fifteen)
        .playerDidScore(PlayerId.SecondPlayer)

      expect(newScoreCalculator.firstPlayerScore).toEqual(Score.Love)
      expect(newScoreCalculator.secondPlayerScore).toEqual(Score.Thirty)
    })
  })
})
