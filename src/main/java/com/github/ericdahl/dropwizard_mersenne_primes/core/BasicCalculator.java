package com.github.ericdahl.dropwizard_mersenne_primes.core;

import com.github.ericdahl.dropwizard_mersenne_primes.api.PrimeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class BasicCalculator implements PrimeCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalculator.class);

    private final BigInteger TWO = BigInteger.valueOf(2);

    @Override
    public PrimeResult calculate(int n) {
        LOGGER.info("Calculating primality for n=[{}] in (2**n)-1", n);

        BigInteger p = TWO.pow(n).subtract(BigInteger.ONE);

        for (BigInteger i = TWO; i.compareTo(p) < 0; i = i.add(BigInteger.ONE))
        {
            if (p.mod(i).equals(BigInteger.ZERO))
            {
                return new PrimeResult(n, false);
            }
        }
        return new PrimeResult(n, true);
    }
}
