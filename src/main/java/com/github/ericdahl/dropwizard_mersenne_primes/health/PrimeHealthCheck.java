package com.github.ericdahl.dropwizard_mersenne_primes.health;

import com.codahale.metrics.health.HealthCheck;
import com.github.ericdahl.dropwizard_mersenne_primes.core.LucasLehmerCalculator;
import com.github.ericdahl.dropwizard_mersenne_primes.core.PrimeCalculator;

public class PrimeHealthCheck extends HealthCheck {

    private PrimeCalculator primeCalculator = new LucasLehmerCalculator();

    @Override
    protected Result check() throws Exception {
        if (primeCalculator.calculate(2).isPrime()) {
            return Result.healthy();
        }
        return Result.unhealthy("failed to properly calculate");
    }
}
