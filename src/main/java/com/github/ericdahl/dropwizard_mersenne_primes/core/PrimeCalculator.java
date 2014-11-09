package com.github.ericdahl.dropwizard_mersenne_primes.core;

import com.github.ericdahl.dropwizard_mersenne_primes.api.PrimeResult;

public interface PrimeCalculator {
    PrimeResult calculate(int n);
}
