package com.dicegame;

import java.util.Random;

public class DiceGame {

    public DiceGameResult execute(DiceGamePlayContext playContext) {
        long numberOfWins = 0;
        long numberOfGames = playContext.getNumberOfGames();

        for (int i = 0; i < numberOfGames; i++) {
            if (playGame(playContext)) {
                numberOfWins++;
            }
        }

        return new DiceGameResult.Builder()
                .withDiceGamePlayContext(playContext)
                .withNumberOfWins(numberOfWins)
                .build();
    }

    private boolean playGame(DiceGamePlayContext playContext) {
        int numberOfRolls = playContext.getNumberOfRolls();
        for (int i = 0; i < numberOfRolls; i++) {
            if (rollDices(playContext.getWinDigitFromOneToSix(), playContext.getNumberOfDices())) {
                return true;
            }
        }
        return false;
    }

    private boolean rollDices(int winDigitFromOneToSix, int dices) {
        boolean result = true;
        Random random = new Random();

        for (int i = 0; i < dices; i++) {
            int randomNumber = random.nextInt(6) + 1;
            if (randomNumber != winDigitFromOneToSix) {
                result = false;
                break;
            }
        }
        return result;
    }
}
