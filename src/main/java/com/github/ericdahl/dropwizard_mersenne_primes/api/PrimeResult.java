package com.github.ericdahl.dropwizard_mersenne_primes.api;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PrimeResult {
    private long n;
    private boolean prime;

    @JsonCreator
    public PrimeResult(@JsonProperty("n") final long n, @JsonProperty("prime") final boolean prime) {
        this.n = n;
        this.prime = prime;
    }

    public boolean isPrime() {
        return prime;
    }

    public long getN() {
        return n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimeResult that = (PrimeResult) o;

        return Objects.equals(n, that.n) && Objects.equals(prime, that.prime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, prime);
    }

    @Override
    public String toString() {
        return "PrimeResult{" +
                "prime=" + prime +
                ", n=" + n +
                '}';
    }
}
