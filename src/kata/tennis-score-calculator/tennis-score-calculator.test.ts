import { TennisScoreCalculator } from './tennis-score-calculator'

describe("TennisScoreCalculator", () => {

  describe("initialization", () => {
    it("should not throw during initialization", () => {
      expect(() => TennisScoreCalculator()).not.toThrow()
    })

    it("should start with first and second player score `love - love`", () => {
      const tennisScoreCalculator = TennisScoreCalculator();

      expect(tennisScoreCalculator.firstPlayerScore).toEqual("love")
      expect(tennisScoreCalculator.secondPlayerScore).toEqual("love")
    })

    it("should be able to initialize the initial score", () => {
      const tennisScoreCalculator = TennisScoreCalculator("15", "love");

      expect(tennisScoreCalculator.firstPlayerScore).toEqual("15")
      expect(tennisScoreCalculator.secondPlayerScore).toEqual("love")
    })
  })
})
