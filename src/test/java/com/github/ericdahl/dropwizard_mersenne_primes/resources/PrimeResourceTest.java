package com.github.ericdahl.dropwizard_mersenne_primes.resources;

import com.github.ericdahl.dropwizard_mersenne_primes.api.PrimeResult;
import com.github.ericdahl.dropwizard_mersenne_primes.core.PrimeCalculator;
import com.sun.jersey.api.client.ClientResponse;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrimeResourceTest {

    private static PrimeCalculator primeCalculator = mock(PrimeCalculator.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PrimeResource(primeCalculator))
            .build();

    @BeforeClass
    public static void setupMock() {
        when(primeCalculator.calculate(3)).thenReturn(new PrimeResult(3, true));
    }

    @Test
    public void shouldRetrieveEntity() {
        final PrimeResult result = resources.client().resource("/3").get(PrimeResult.class);
        assertThat(result).isEqualTo(new PrimeResult(3, true));
    }

    @Test
    public void shouldHaveCacheHeaders() {
        final ClientResponse response = resources.client().resource("/3").get(ClientResponse.class);
        assertThat(response.getHeaders().get("Cache-Control")).contains("no-transform, max-age=31536000");
    }
}
