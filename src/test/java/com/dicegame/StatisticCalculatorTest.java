package com.dicegame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class StatisticCalculatorTest {

    private StatisticCalculator statisticCalculator;

    @Before
    public void setUp() {
        statisticCalculator = new StatisticCalculator();
    }

    @Test
    public void testCalculateDiceGameStatistic() {
        DiceGamePlayContext diceGamePlayContext = new DiceGamePlayContext.Builder()
                .withWinDigitFromOneToSix(6)
                .withNumberOfGames(1000000)
                .withNumberOfRolls(24)
                .withNumberOfDices(2)
                .build();

        DiceGameResult diceGameResult = new DiceGameResult.Builder()
                .withDiceGamePlayContext(diceGamePlayContext)
                .withNumberOfWins(492000)
                .build();

        DiceGameStatistic diceGameStatistic = statisticCalculator.calculateDiceGameStatistic(diceGameResult);

        assertEquals("0.49", diceGameStatistic.getMean().toPlainString());
        assertEquals("249900.00", diceGameStatistic.getVariance().toPlainString());
        assertEquals("500", diceGameStatistic.getStandardDeviation().toPlainString());
    }

    @Test
    public void testCalculateMean() {
        assertEquals(BigDecimal.valueOf(50, 2), statisticCalculator.calculateMean(BigDecimal.valueOf(5), BigDecimal.valueOf(10)));
    }

    @Test
    public void testCalculateVariance() {
        assertEquals(BigDecimal.valueOf(100, 2), statisticCalculator.calculateVariance(BigDecimal.valueOf(4), BigDecimal.valueOf(0.5)));
    }

    @Test
    public void testCalculateStandardDeviation() {
        assertEquals(BigDecimal.valueOf(1.0), statisticCalculator.calculateStandardDeviation(BigDecimal.valueOf(100, 2)));
    }
}
