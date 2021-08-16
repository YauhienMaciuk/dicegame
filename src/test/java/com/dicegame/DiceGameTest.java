package com.dicegame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DiceGameTest {

    private DiceGame diceGame;

    @Before
    public void setUp() {
        diceGame = new DiceGame();
    }

    @Test
    public void testExecute() {
        int winDigitFromOneToSix = 6;
        int numberOfDices = 2;
        int numberOfRolls = 24;
        long numberOfGames = 1000000;

        DiceGamePlayContext playContext = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(winDigitFromOneToSix)
                .withNumberOfDices(numberOfDices)
                .withNumberOfRolls(numberOfRolls)
                .withNumberOfGames(numberOfGames)
                .build();

        DiceGameResult diceGameResult = diceGame.execute(playContext);

        assertEquals(playContext, diceGameResult.getDiceGamePlayContext());
        assertTrue( diceGameResult.getNumberOfWins() > 490000);
        assertTrue( diceGameResult.getNumberOfWins() < 495000);
    }
}
