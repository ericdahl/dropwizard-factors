package com.github.ericdahl.dropwizard_factors.health;

import com.codahale.metrics.health.HealthCheck;
import com.github.ericdahl.dropwizard_factors.core.BasicFactorCalculator;
import com.github.ericdahl.dropwizard_factors.core.FactorCalculator;

public class FactorHealthCheck extends HealthCheck {

    private FactorCalculator factorCalculator = new BasicFactorCalculator();

    @Override
    protected Result check() throws Exception {
        if (factorCalculator.factorize(12).size() == 3) {
            return Result.healthy();
        }
        return Result.unhealthy("failed to properly factorize");
    }
}
