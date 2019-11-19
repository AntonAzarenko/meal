package com.azarenka.integrationtest.rest;

import static org.junit.Assert.assertEquals;

import com.azarenka.service.response.FoodResponse;

import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@EnableAutoConfiguration
public class FoodControllerIntegrationTest extends WebTests {

    @Test
    public void getAll() {
        ResponseEntity<List<FoodResponse>> responseEntity =
            restTemplate.exchange(createURL("/foods"), HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<FoodResponse>>() {
                });
        List<FoodResponse> foodResponses = responseEntity.getBody();
        assertEquals(2, foodResponses.size());
    }
}
