package com.dicegame;

public class DiceGameRunner {

    public static void main(String[] args) {

        DiceGame diceGame = new DiceGame();
        StatisticCalculator statisticCalculator = new StatisticCalculator();

        DiceGamePlayContext playContextForFirstGame = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfDices(1)
                .withNumberOfRolls(4)
                .withNumberOfGames(1000000)
                .build();

        DiceGameResult resultOfFirstGame = diceGame.execute(playContextForFirstGame);
        System.out.println(resultOfFirstGame);

        DiceGameStatistic diceGameStatisticOfFirstGame = statisticCalculator.calculateDiceGameStatistic(resultOfFirstGame);
        System.out.println(diceGameStatisticOfFirstGame);

        DiceGamePlayContext playContextForSecondGame = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfDices(2)
                .withNumberOfRolls(24)
                .withNumberOfGames(1000000)
                .build();

        DiceGameResult resultOfSecondGame = diceGame.execute(playContextForSecondGame);
        System.out.println(resultOfSecondGame);

        DiceGameStatistic diceGameStatisticOfSecondGame = statisticCalculator.calculateDiceGameStatistic(resultOfSecondGame);
        System.out.println(diceGameStatisticOfSecondGame);
    }
}