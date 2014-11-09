package com.github.ericdahl.dropwizard_mersenne_primes;

import com.github.ericdahl.dropwizard_mersenne_primes.health.PrimeHealthCheck;
import com.github.ericdahl.dropwizard_mersenne_primes.resources.PrimeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends Application<AppConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-mersenne-primes";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        // nothing special to initialize
    }

    @Override
    public void run(final AppConfiguration config, final Environment environment) {
        LOGGER.info("config loaded: [{}]", config.getCalculator());

        environment.healthChecks().register("primes", new PrimeHealthCheck());
        environment.jersey().register(new PrimeResource(config.createCalculator()));
    }
}
