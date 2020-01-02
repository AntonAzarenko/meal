package com.azarenka.integrationtest.rest;

import com.azarenka.domain.Report;
import com.azarenka.service.response.BookerResponse;
import com.azarenka.service.util.TimeUtil;
import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@EnableAutoConfiguration
public class BookerControllerIntegrationTest extends WebTests {

    @Test
    public void testReport() {
        ResponseEntity<Report> responseEntity = getReport();
        Report actualReport = responseEntity.getBody();
        Report expectedReport = buildReport("25.25", "25.25", "25.25", "25.25", "25.25", "25.25", "25.25", "176.75");
        assertEquals(expectedReport, actualReport);
    }

    @Test// TODO reimplement this test
    public void testSave() {
        /*sendDataToController(buildBookerResponse("0.75", "CLOTHES"));
        sendDataToController(buildBookerResponse("0.75", "HOME"));
        sendDataToController(buildBookerResponse("0.75", "FOOD"));
        sendDataToController(buildBookerResponse("0.75", "GAS"));
        sendDataToController(buildBookerResponse("0.75", "CREDIT"));
        sendDataToController(buildBookerResponse("0.75", "DRINK"));
        sendDataToController(buildBookerResponse("0.75", "PETS"));
        Report actualReport = getReport().getBody();
        Report expectedReport = buildReport("26.00", "26.00", "26.00", "26.00", "26.00", "26.00", "26.00", "182.00");
        assertEquals(expectedReport, actualReport);
        rollbackSave();*/
    }

    private BookerResponse buildBookerResponse(String countPrice, String type) {
        BookerResponse bookerResponse = new BookerResponse();
        bookerResponse.setCountPrice(countPrice);
        bookerResponse.setType(type);
        return bookerResponse;
    }

    private void sendDataToController(BookerResponse booker) {
        HttpEntity<BookerResponse> request = new HttpEntity<>(booker, headers);
        restTemplate.postForObject(createURL("/booker/"), request, BookerResponse.class);
    }

    private ResponseEntity<Report> getReport() {
        ResponseEntity<Report> responseEntity =
                restTemplate.exchange(createURL("/booker/report/2019/12"), HttpMethod.GET, entity,
                        new ParameterizedTypeReference<Report>() {
                        });
        return responseEntity;
    }

    private Report buildReport(String food, String home, String gas, String credit, String pets, String drink, String clothes, String profit) {
        Report report = new Report();
        report.setPets(new BigDecimal(pets));
        report.setCredit(new BigDecimal(credit));
        report.setHome(new BigDecimal(home));
        report.setClothes(new BigDecimal(clothes));
        report.setGas(new BigDecimal(gas));
        report.setAlcohol(new BigDecimal(drink));
        report.setFood(new BigDecimal(food));
        report.setMonth(TimeUtil.getMonth(LocalDate.of(2019, 12, 1)));
        report.setYear("2019");
        report.setProfit(new BigDecimal(profit));
        report.setCurrentDateTime("2019 12 25");
        return report;
    }

    private void rollbackSave() {
        sendDataToController(buildBookerResponse("-0.75", "CLOTHES"));
        sendDataToController(buildBookerResponse("-0.75", "HOME"));
        sendDataToController(buildBookerResponse("-0.75", "FOOD"));
        sendDataToController(buildBookerResponse("-0.75", "GAS"));
        sendDataToController(buildBookerResponse("-0.75", "CREDIT"));
        sendDataToController(buildBookerResponse("-0.75", "DRINK"));
        sendDataToController(buildBookerResponse("-0.75", "PETS"));
    }
}
