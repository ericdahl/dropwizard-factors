package com.github.ericdahl.dropwizard_factors.resources;

import com.github.ericdahl.dropwizard_factors.api.FactorResult;
import com.github.ericdahl.dropwizard_factors.core.FactorCalculator;
import com.sun.jersey.api.client.ClientResponse;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Arrays;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FactorResourceTest {

    private static FactorCalculator factorCalculator = mock(FactorCalculator.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new FactorResource(factorCalculator))
            .build();

    @BeforeClass
    public static void setupMock() {
        when(factorCalculator.factorize(12)).thenReturn(Arrays.asList(2, 2, 3));
    }

    @Test
    public void shouldRetrieveEntity() {
        final FactorResult result = resources.client().resource("/12").get(FactorResult.class);
        assertThat(result).isEqualTo(new FactorResult(12, Arrays.asList(2, 2, 3)));
    }

    @Test
    public void shouldHaveCacheHeaders() {
        final ClientResponse response = resources.client().resource("/12").get(ClientResponse.class);
        assertThat(response.getHeaders().get("Cache-Control")).contains("no-transform, max-age=31536000");
    }
}
