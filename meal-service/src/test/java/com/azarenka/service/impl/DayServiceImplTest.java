package com.azarenka.service.impl;

import com.azarenka.domain.Day;
import com.azarenka.repository.DayRepository;
import com.azarenka.service.api.DayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;

@RunWith(MockitoJUnitRunner.class)
public class DayServiceImplTest {

    private DayService service;
    private DayRepository repository;

    @Before
    public void setUp() {
        service = new DayServiceImpl();
        repository = createMock(DayRepository.class);
        Whitebox.setInternalState(service, "dayRepository", repository);
    }

    @Test
    public void testGetAll() {
        expect(repository.getAll()).andReturn(new ArrayList<Day>());
        replay(repository);
        service.getAll();
        verify(repository);
    }
}
