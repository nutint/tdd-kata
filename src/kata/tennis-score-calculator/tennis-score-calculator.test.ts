import {TennisScoreCalculator} from './tennis-score-calculator'
import {Score} from "./score";

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
        .playerDidScore("firstPlayer")

      expect(newScoreCalculator.firstPlayerScore).toEqual(Score.Fifteen)
      expect(newScoreCalculator.secondPlayerScore).toEqual(Score.Love)
    })
  })
})
