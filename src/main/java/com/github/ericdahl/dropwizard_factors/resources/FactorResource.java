package com.github.ericdahl.dropwizard_factors.resources;

import com.codahale.metrics.annotation.Timed;
import com.github.ericdahl.dropwizard_factors.api.FactorResult;
import com.github.ericdahl.dropwizard_factors.core.FactorCalculator;
import io.dropwizard.jersey.caching.CacheControl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class FactorResource {

    private final FactorCalculator calculator;

    public FactorResource(FactorCalculator calculator) {
        this.calculator = calculator;
    }

    @GET
    @Path("{n}")
    @CacheControl(immutable = true)
    @Timed
    public FactorResult calculate(@PathParam("n") int n) {
        return new FactorResult(n, calculator.factorize(n));
    }
}
