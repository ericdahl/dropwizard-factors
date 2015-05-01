package com.github.ericdahl.dropwizard_factors.api;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class FactorResult {
    private long n;
    private List<Integer> factors;

    @JsonCreator
    public FactorResult(@JsonProperty("n") final long n, @JsonProperty("factors") final List<Integer> factors) {
        this.n = n;
        this.factors = factors;
    }

    public List<Integer> getFactors() {
        return factors;
    }

    public long getN() {
        return n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FactorResult that = (FactorResult) o;

        return Objects.equals(n, that.n) && Objects.equals(factors, that.factors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, factors);
    }

    @Override
    public String toString() {
        return "FactorResult{" +
                "factors=" + factors +
                ", n=" + n +
                '}';
    }
}
