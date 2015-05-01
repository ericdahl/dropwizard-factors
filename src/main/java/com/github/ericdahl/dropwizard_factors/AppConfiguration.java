package com.github.ericdahl.dropwizard_factors;

import com.github.ericdahl.dropwizard_factors.core.FactorCalculator;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class AppConfiguration extends Configuration {

    @NotNull
    private Class<? extends FactorCalculator> calculator;

    public Class<? extends FactorCalculator> getCalculator() {
        return calculator;
    }

    public void setCalculator(Class<? extends FactorCalculator> calculator) {
        this.calculator = calculator;
    }

    public FactorCalculator createCalculator() {
        try {
            return calculator.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("Cannot instantiate class [" + calculator + "]");
        }
    }
}
