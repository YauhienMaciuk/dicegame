package com.dicegame;

public class DiceGameResult {
    private DiceGamePlayContext diceGamePlayContext;
    private long numberOfWins;

    public DiceGamePlayContext getDiceGamePlayContext() {
        return diceGamePlayContext;
    }

    public long getNumberOfWins() {
        return numberOfWins;
    }

    public static class Builder {
        private DiceGamePlayContext diceGamePlayContext;
        private long numberOfWins;

        public Builder withDiceGamePlayContext(DiceGamePlayContext diceGamePlayContext) {
            this.diceGamePlayContext = diceGamePlayContext;
            return this;
        }

        public Builder withNumberOfWins(long numberOfWins) {
            this.numberOfWins = numberOfWins;
            return this;
        }

        public DiceGameResult build() {
            DiceGameResult diceGameResult = new DiceGameResult();
            diceGameResult.diceGamePlayContext = this.diceGamePlayContext;
            diceGameResult.numberOfWins = this.numberOfWins;
            return diceGameResult;
        }
    }

    @Override
    public String toString() {
        return String.format("DiceGameResult { diceGamePlayContext = %s, numberOfWins = %s }",
                diceGamePlayContext, numberOfWins);
    }
}
