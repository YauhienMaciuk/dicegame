package com.dicegame;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class StatisticCalculator {

    public DiceGameStatistic calculateDiceGameStatistic(DiceGameResult result) {
        BigDecimal numberOfWins = BigDecimal.valueOf(result.getNumberOfWins());
        BigDecimal numberOfGames = BigDecimal.valueOf(result.getDiceGamePlayContext().getNumberOfGames());

        BigDecimal mean = calculateMean(numberOfWins, numberOfGames);
        BigDecimal variance = calculateVariance(numberOfGames, mean);
        BigDecimal standardDeviation = calculateStandardDeviation(variance);

        return new DiceGameStatistic.Builder()
                .withMean(mean)
                .withVariance(variance)
                .withStandardDeviation(standardDeviation)
                .build();
    }

    public BigDecimal calculateMean(BigDecimal numberOfWins, BigDecimal numberOfGames) {
        return numberOfWins.divide(numberOfGames, 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateVariance(BigDecimal numberOfTrails, BigDecimal mean) {
        return numberOfTrails.multiply(mean).multiply(BigDecimal.valueOf(1).subtract(mean)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateStandardDeviation(BigDecimal variance) {
        return variance.sqrt(new MathContext(2, RoundingMode.HALF_UP));
    }
}