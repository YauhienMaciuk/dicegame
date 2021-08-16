package com.dicegame;

import java.math.BigDecimal;

public class DiceGameStatistic {
    private BigDecimal mean;
    private BigDecimal variance;
    private BigDecimal standardDeviation;

    public BigDecimal getMean() {
        return mean;
    }

    public BigDecimal getVariance() {
        return variance;
    }

    public BigDecimal getStandardDeviation() {
        return standardDeviation;
    }

    public static class Builder {
        private BigDecimal mean;
        private BigDecimal variance;
        private BigDecimal standardDeviation;

        public Builder withMean(BigDecimal mean) {
            this.mean = mean;
            return this;
        }

        public Builder withVariance(BigDecimal variance) {
            this.variance = variance;
            return this;
        }

        public Builder withStandardDeviation(BigDecimal standardDeviation) {
            this.standardDeviation = standardDeviation;
            return this;
        }

        public DiceGameStatistic build() {
            DiceGameStatistic diceGameStatistic = new DiceGameStatistic();
            diceGameStatistic.mean = this.mean;
            diceGameStatistic.variance = this.variance;
            diceGameStatistic.standardDeviation = this.standardDeviation;
            return diceGameStatistic;
        }
    }

    @Override
    public String toString() {
        return String.format("DiceGameStatistic { mean = %s, variance = %s, standardDeviation = %s }",
                mean.toPlainString(), variance.toPlainString(), standardDeviation.toPlainString());
    }
}