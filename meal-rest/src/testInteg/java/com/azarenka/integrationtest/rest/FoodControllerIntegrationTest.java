package com.azarenka.integrationtest.rest;

import static org.junit.Assert.assertEquals;

import com.azarenka.domain.Filter;
import com.azarenka.service.response.BookerResponse;
import com.azarenka.service.response.FoodResponse;

import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@EnableAutoConfiguration
public class FoodControllerIntegrationTest extends WebTests {

    @Test
    public void getAll() {
        ResponseEntity<List<FoodResponse>> responseEntity =
                restTemplate.exchange(createURL("/foods/"), HttpMethod.GET, entity,
                        new ParameterizedTypeReference<List<FoodResponse>>() {
                        });
        List<FoodResponse> foodResponses = responseEntity.getBody();
        assertEquals(10, foodResponses.size());
        List<FoodResponse> expectedFoodResponse = prepareExpectedFood();
        assertFoodResponses(expectedFoodResponse.stream().sorted((e, f) -> e.compareTo(f.getTitle())).collect(Collectors.toList()),
                foodResponses.stream().sorted((e, f) -> e.compareTo(f.getTitle())).collect(Collectors.toList()));
    }

    private void assertFoodResponses(List<FoodResponse> expectedFoodResponse, List<FoodResponse> actualFoodResponse) {
        assertEquals(expectedFoodResponse.size(), actualFoodResponse.size());
        IntStream.range(0, expectedFoodResponse.size()).forEach(i -> {
            assertFoodResponse(expectedFoodResponse.get(i), actualFoodResponse.get(i));
        });
    }

    private void assertFoodResponse(FoodResponse expected, FoodResponse actual) {
        assertEquals(expected.getCalories(), actual.getCalories());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getCarbohydrates(), actual.getCarbohydrates());
        assertEquals(expected.getFats(), actual.getFats());
        assertEquals(expected.getProtein(), actual.getProtein());
        assertEquals(expected.getWeight(), actual.getWeight(), 0);
    }

    private List<FoodResponse> prepareExpectedFood() {
        List<FoodResponse> foodResponses = Arrays.asList(
                buildFoodResponse("Сосиски", 0, 0, 0, 1, 0.7, "d99c4f05-fec0-47bf-8652-cb6dca9f236e", "штук"),
                buildFoodResponse("Мандарин", 0, 1, 0, 0, 1, "a916143d-720c-488a-8179-0511c347ee9d", "штук"),
                buildFoodResponse("Салат овощной", 0, 1, 0, 0, 1, "2a821e5d-de18-402a-a54a-5f1846b06e52", "стаканов"),
                buildFoodResponse("Рыба вареная", 0, 0, 0, 1, 50, "e9d64635-52d8-4f52-8de8-95c9e9858c21", "граммов"),
                buildFoodResponse("Апельсин", 0, 1, 0, 0, 1, "897dadb9-aaec-4a53-9a20-606ef965761f", "штук"),
                buildFoodResponse("Рассольник", 0, 0, 1, 0, 0.3, "fe94dc49-29d2-4626-83d3-078f7f5c4ce9", "чайных ложек"),
                buildFoodResponse("Сметана", 0, 0, 1, 0, 1, "a8c6bf79-f9e7-4f48-8d95-cecb9965e5e7", "чайных ложек"),
                buildFoodResponse("Хлеб", 0, 1, 0, 0, 1, "efdfaef5-6063-45e1-9fac-0f6f8205046b", "штук"),
                buildFoodResponse("Йогурт(н\\ж 0.1 -0.3%)", 0, 0, 0, 1, 120, "33a0499d-8469-4d2b-89fd-ebfe28669251",
                        "граммов"),
                buildFoodResponse("Арахис стручковый", 0, 0, 1, 0, 6, "4ff161cf-9d8e-41c8-b79f-1eda156777c9", "штук")
        );
        return foodResponses;
    }

    private FoodResponse buildFoodResponse(String title, int calories, int carbohydrates, int fats, int protein,
                                           double weight, String id, String description) {
        FoodResponse foodResponse = new FoodResponse();
        foodResponse.setTitle(title);
        foodResponse.setCalories(calories);
        foodResponse.setCarbohydrates(carbohydrates);
        foodResponse.setFats(fats);
        foodResponse.setProtein(protein);
        foodResponse.setWeight(weight);
        foodResponse.setId(id);
        foodResponse.setDescription(description);
        return foodResponse;
    }
}
