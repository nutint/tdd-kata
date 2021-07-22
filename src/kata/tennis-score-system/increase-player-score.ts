import {PlayerScore} from "./player-score";

export function increasePlayerScore(initialFirstPlayerScore: PlayerScore) {
    switch (initialFirstPlayerScore) {
        case PlayerScore.Love:
            return PlayerScore.Fifteen;
        case PlayerScore.Fifteen:
            return PlayerScore.Thirty;
        default:
            return PlayerScore.Forty;
    }
}
