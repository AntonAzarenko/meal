package com.azarenka.repository.testinteg;

import com.azarenka.domain.Day;
import com.azarenka.repository.DayRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedPostgresConfig.class})
public class DayRepositoryIntegrationTest {

    @Autowired
    private DayRepository dayRepository;

    @Test
    public void testGetAll(){
        assertEquals(7, dayRepository.getAll().size());
    }

    @Test
    public void testGetById(){
        Day day = new Day();
        day.setId("aafd457c-bfe4-4033-8ee0-8674f4ba7d0d");
        day.setDay("Monday");
    }
}
