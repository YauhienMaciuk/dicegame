package com.dicegame;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DiceGamePlayContextTest {

    @Test
    public void testBuild() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfGames(1000)
                .withNumberOfRolls(4)
                .withNumberOfDices(1)
                .build();

        assertNotNull(context);
    }

    @Test(expected = DiceGameException.class)
    public void testBuildWhenWinDigitFromOneToSixIsSeven() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(7)
                .withNumberOfGames(1000)
                .withNumberOfRolls(4)
                .withNumberOfDices(1)
                .build();
    }

    @Test(expected = DiceGameException.class)
    public void testBuildWhenNumberOfGamesIsZero() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfGames(0)
                .withNumberOfRolls(4)
                .withNumberOfDices(1)
                .build();
    }

    @Test(expected = DiceGameException.class)
    public void testBuildWhenNumberOfRollsIsZero() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfGames(1000)
                .withNumberOfRolls(0)
                .withNumberOfDices(1)
                .build();
    }

    @Test(expected = DiceGameException.class)
    public void testBuildWhenNumberOfDicesIsZero() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfGames(1000)
                .withNumberOfRolls(4)
                .withNumberOfDices(0)
                .build();
    }

    @Test(expected = DiceGameException.class)
    public void testBuildWithoutNumberOfDices() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfGames(1000)
                .withNumberOfRolls(4)
                .build();
    }

    @Test(expected = DiceGameException.class)
    public void testBuildWithoutNumberOfRolls() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfGames(1000)
                .withNumberOfDices(1)
                .build();
    }

    @Test(expected = DiceGameException.class)
    public void testBuildWithoutNumberOfGames() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfRolls(4)
                .withNumberOfDices(1)
                .build();
    }

    @Test(expected = DiceGameException.class)
    public void testBuildWithoutWinDigitFromOneToSix() {
        DiceGamePlayContext context = new DiceGamePlayContext.Builder()
                .withNumberOfGames(1000)
                .withNumberOfRolls(4)
                .withNumberOfDices(1)
                .build();
    }
}
