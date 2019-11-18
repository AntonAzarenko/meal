package com.azarenka.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.azarenka.domain.Day;
import com.azarenka.repository.DayRepository;
import com.azarenka.service.api.DayService;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class DayServiceImplTest {
    @InjectMocks
    private DayService service = new DayServiceImpl();
    @Mock
    private DayRepository repository;

    @Test
    public void testGetAll() {
        when(repository.getAll()).thenReturn(Collections.emptyList());
        service.getAll();
        verify(repository).getAll();
    }

    @Test
    public void testGetByName() {
        when(repository.findDayByName("admin@mail.ru")).thenReturn(any());
        service.getDayByName("admin@mail.ru");
        verify(repository).findDayByName("admin@mail.ru");
    }
}
