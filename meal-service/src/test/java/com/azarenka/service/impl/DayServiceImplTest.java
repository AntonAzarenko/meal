package com.azarenka.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
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
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DayServiceImplTest {
    @InjectMocks
    private DayService service = new DayServiceImpl();
    @Mock
    private DayRepository repository;

    @Test
    public void testGetAll() {
        when(repository.getAll()).thenReturn(ArgumentMatchers.anyList());
        service.getAll();
        verify(repository.getAll());
    }

    @Test
    public void testGetByName() {
        when(repository.findDayByName(StringUtils.EMPTY)).thenReturn(any(Day.class));
        service.getDayByName(StringUtils.EMPTY);
        verify(repository);
    }
}
