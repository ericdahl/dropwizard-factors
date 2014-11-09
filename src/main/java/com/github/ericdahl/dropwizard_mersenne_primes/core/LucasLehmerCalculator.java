package com.github.ericdahl.dropwizard_mersenne_primes.core;

import com.github.ericdahl.dropwizard_mersenne_primes.api.PrimeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class LucasLehmerCalculator implements PrimeCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LucasLehmerCalculator.class);

    private final BigInteger TWO = BigInteger.valueOf(2);

    @Override
    public PrimeResult calculate(int n) {
        LOGGER.info("Calculating primality for n=[{}] in (2**n)-1", n);

        BigInteger s = new BigInteger("4");

        if (n == 2) {
            return new PrimeResult(n, true);
        }

        BigInteger m = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
        for (int i = 0; i < (n - 2); ++i) {
            s = s.pow(2).subtract(TWO).remainder(m);
        }

        return new PrimeResult(n, s.equals(BigInteger.ZERO));
    }
}
