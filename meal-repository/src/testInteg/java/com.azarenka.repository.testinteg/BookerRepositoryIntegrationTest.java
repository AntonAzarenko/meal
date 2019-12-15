package com.azarenka.repository.testinteg;

import com.azarenka.domain.Booker;
import com.azarenka.domain.CheckType;
import com.azarenka.repository.BookerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedPostgresConfig.class})
public class BookerRepositoryIntegrationTest {

    @Autowired
    private BookerRepository bookerRepository;

    @Test
    public void getAllByUserEmail() {
        Booker expectedBooker = buildBooker();
        assertEquals(Arrays.asList(expectedBooker), bookerRepository.getAllByUserEmail("admin@mail.ru"));
    }

    @Test
    public void save() {
        Booker booker = new Booker();
        booker.setId(UUID.randomUUID().toString());
        booker.setCheckDate(LocalDate.of(2019,12,14));
        booker.setUserEmail("admin@mail.ru");
        booker.setType(CheckType.DRINK);
        booker.setCountPrice(new BigDecimal("25.25"));
        bookerRepository.save(booker);
        List<Booker> bookers = bookerRepository.getAllByUserEmail("admin@mail.ru");
        assertEquals(2, bookers.size());
    }

    private Booker buildBooker() {
        Booker booker = new Booker();
        booker.setId("zzxcxcc-zxczxc-zxczxc");
        booker.setCheckDate(LocalDate.of(2019,12,14));
        booker.setUserEmail("admin@mail.ru");
        booker.setType(CheckType.GAS);
        booker.setCountPrice(new BigDecimal("25.25"));
        return booker;
    }
}
