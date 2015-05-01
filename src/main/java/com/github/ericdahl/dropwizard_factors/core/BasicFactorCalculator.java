package com.github.ericdahl.dropwizard_factors.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BasicFactorCalculator implements FactorCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicFactorCalculator.class);

    @Override
    public List<Integer> factorize(int n) {
        LOGGER.info("Calculating factors for n = [{}]", n);

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; n > 1; ) {
            if (n % i == 0) {
                factors.add(i);
                n /= i;
            } else {
                ++i;
            }
        }

        return factors;
    }
}
