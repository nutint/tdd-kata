import {incrementScore, TennisScoreCalculator} from './tennis-score-calculator'
import {Score} from "./score";
import {PlayerId} from "./player-id";

describe("TennisScoreCalculator", () => {

  describe("initialization", () => {
    it("should not throw during initialization", () => {
      expect(() => TennisScoreCalculator()).not.toThrow()
    })

    it("should start with first and second player score `love - love`, and winner is null", () => {
      const tennisScoreCalculator = TennisScoreCalculator();

      expect(tennisScoreCalculator.firstPlayerScore).toEqual(Score.Love)
      expect(tennisScoreCalculator.secondPlayerScore).toEqual(Score.Love)
      expect(tennisScoreCalculator.winner).toEqual(PlayerId.NoPlayer)
      expect(tennisScoreCalculator.deuce).toEqual(false)
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

    it("start from love-love then second player score twice, should become love-thirty", () => {
      const newScoreCalculator = TennisScoreCalculator(Score.Love, Score.Love)
        .playerDidScore(PlayerId.SecondPlayer)
        .playerDidScore(PlayerId.SecondPlayer)

      expect(newScoreCalculator.firstPlayerScore).toEqual(Score.Love)
      expect(newScoreCalculator.secondPlayerScore).toEqual(Score.Thirty)
    })

    it("current score is fifteen-forty then second player score then second player wins", () => {
      const newScoreCalculator = TennisScoreCalculator(Score.Fifteen, Score.Forty)
        .playerDidScore(PlayerId.SecondPlayer);

      expect(newScoreCalculator.winner).toEqual(PlayerId.SecondPlayer);
      expect(newScoreCalculator.firstPlayerScore).toEqual(Score.Love);
      expect(newScoreCalculator.secondPlayerScore).toEqual(Score.Love);
    })

    it("current score is thirty-forty then first player score then deuce is true", () => {
      const newScoreCalculator = TennisScoreCalculator(Score.Thirty, Score.Forty)
        .playerDidScore(PlayerId.FirstPlayer);

      expect(newScoreCalculator.deuce).toEqual(true);
    })
  })

  describe("incrementScore", () => {
    it("should return fifteen when start with love", () => {
      const actual = incrementScore(Score.Love)

      expect(actual).toEqual(Score.Fifteen)
    })

    it("should return thirty when start with fifteen", () => {
      const actual = incrementScore(Score.Fifteen)

      expect(actual).toEqual(Score.Thirty)
    })

    it("should return forty when start with thirty", () => {
      const actual = incrementScore(Score.Thirty)

      expect(actual).toEqual(Score.Forty)
    })
  })
})
