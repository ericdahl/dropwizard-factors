package com.github.ericdahl.dropwizard_mersenne_primes;

import com.github.ericdahl.dropwizard_mersenne_primes.core.PrimeCalculator;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class AppConfiguration extends Configuration {

    @NotNull
    private Class<? extends PrimeCalculator> calculator;

    public Class<? extends PrimeCalculator> getCalculator() {
        return calculator;
    }

    public void setCalculator(Class<? extends PrimeCalculator> calculator) {
        this.calculator = calculator;
    }

    public PrimeCalculator createCalculator() {
        try {
            return calculator.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("Cannot instantiate class [" + calculator + "]");
        }
    }
}
