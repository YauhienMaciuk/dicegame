package com.dicegame;

public class DiceGamePlayContext {
    private int winDigitFromOneToSix;
    private int numberOfDices;
    private int numberOfRolls;
    private long numberOfGames;

    public int getWinDigitFromOneToSix() {
        return winDigitFromOneToSix;
    }

    public int getNumberOfDices() {
        return numberOfDices;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }

    public long getNumberOfGames() {
        return numberOfGames;
    }

    public static class Builder {
        private int winDigitFromOneToSix;
        private int numberOfDices;
        private int numberOfRolls;
        private long numberOfGames;

        public Builder withWinDigitFromOneToSix(int winDigitFromOneToSix) {
            this.winDigitFromOneToSix = winDigitFromOneToSix;
            return this;
        }

        public Builder withNumberOfDices(int numberOfDices) {
            this.numberOfDices = numberOfDices;
            return this;
        }

        public Builder withNumberOfRolls(int numberOfRolls) {
            this.numberOfRolls = numberOfRolls;
            return this;
        }

        public Builder withNumberOfGames(long numberOfGames) {
            this.numberOfGames = numberOfGames;
            return this;
        }

        public DiceGamePlayContext build() {
            DiceGamePlayContext diceGamePlayContext = new DiceGamePlayContext();
            diceGamePlayContext.winDigitFromOneToSix = this.winDigitFromOneToSix;
            diceGamePlayContext.numberOfDices = this.numberOfDices;
            diceGamePlayContext.numberOfRolls = this.numberOfRolls;
            diceGamePlayContext.numberOfGames = this.numberOfGames;

            validateDiceGamePlayContext(diceGamePlayContext);

            return diceGamePlayContext;
        }

        private void validateDiceGamePlayContext(DiceGamePlayContext diceGamePlayContext) {
            if (diceGamePlayContext.winDigitFromOneToSix < 1 || diceGamePlayContext.winDigitFromOneToSix > 6) {
                throw new DiceGameException(String.format("The winDigitFromOneToSix has to be from 1 to 6, " +
                        "but you try set winDigitFromOneToSix = %s", diceGamePlayContext.winDigitFromOneToSix));
            }
            if (diceGamePlayContext.numberOfDices < 1) {
                throw new DiceGameException(String.format("The number of dices do not have to be less than 1, " +
                        "but you try set numberOfDices = %s", diceGamePlayContext.numberOfDices));
            }
            if (diceGamePlayContext.numberOfRolls < 1) {
                throw new DiceGameException(String.format("The number of rolls does not have to be less than 1, " +
                        "but you try set numberOfRolls = %s", diceGamePlayContext.numberOfRolls));
            }
            if (diceGamePlayContext.numberOfGames < 1) {
                throw new DiceGameException(String.format("The number of games does not have to be less than 1, " +
                        "but you try set numberOfGames = %s", diceGamePlayContext.numberOfGames));
            }
        }
    }

    @Override
    public String toString() {
        return String.format("DiceGamePlayContext{" +
                        "winDigitFromOneToSix = %s, numberOfDices = %s, numberOfRolls = %s, numberOfGames = %s }",
                winDigitFromOneToSix, numberOfDices, numberOfRolls, numberOfGames);
    }
}