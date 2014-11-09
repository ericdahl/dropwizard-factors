package com.github.ericdahl.dropwizard_mersenne_primes.resources;

import com.codahale.metrics.annotation.Timed;
import com.github.ericdahl.dropwizard_mersenne_primes.api.PrimeResult;
import com.github.ericdahl.dropwizard_mersenne_primes.core.PrimeCalculator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PrimeResource {

    private final PrimeCalculator calculator;

    public PrimeResource(PrimeCalculator calculator) {
        this.calculator = calculator;
    }

    @GET
    @Path("{n}")
    @Timed
    public PrimeResult calculate(@PathParam("n") int n) {
        return calculator.calculate(n);
    }
}
