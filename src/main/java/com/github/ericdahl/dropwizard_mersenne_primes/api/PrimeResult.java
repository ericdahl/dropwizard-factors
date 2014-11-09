package com.github.ericdahl.dropwizard_mersenne_primes.api;


import com.fasterxml.jackson.annotation.JsonCreator;

public class PrimeResult {
    private long n;
    private boolean prime;

    @JsonCreator
    public PrimeResult(final long n, final boolean prime) {
        this.n = n;
        this.prime = prime;
    }

    public boolean isPrime() {
        return prime;
    }

    public long getN() {
        return n;
    }
}
