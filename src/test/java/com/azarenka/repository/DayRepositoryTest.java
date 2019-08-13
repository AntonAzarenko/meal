package com.azarenka.repository;

import com.azarenka.domain.Day;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration({
        "classpath:spring/spring-context.xml",
        "classpath:spring/spring-dataBase.xml",
        "classpath:spring/spring-mybatis-bean.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class DayRepositoryTest {

    @Autowired
    private DayRepository dayRepository;

    @Test
    public void getAll() {
        List<Day> days = Arrays.asList(
                buildDay("aafd457c-bfe4-4033-8ee0-8674f4ba7d0d","Monday"),
                buildDay("1ceffdb1-5327-4283-8f9d-ac98ae87faf9", "Tuesday"),
                buildDay("cfda43a6-836d-48d3-906d-b87fb7151503", "Wednesday"),
                buildDay("b272327c-f198-49c2-a45e-a84b19885852","Thursday"),
                buildDay("9852b1da-242e-4f94-aa5d-83d5c9fc6cc8","Friday"),
                buildDay("2a72e105-b91a-4990-8a5e-0ed5a3283b47","Saturday"),
                buildDay("1d9cc961-9c8e-44d4-8066-10d3dc8d3eb2","Sunday")
        );
        assertEquals(days, dayRepository.getAll());
    }

    private Day buildDay(String id, String days){
        Day day = new Day();
        day.setId(id);
        day.setDay(days);
        return day;
    }
}