package com.azarenka.service.impl;

import com.azarenka.repository.MealRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;

@RunWith(MockitoJUnitRunner.class)
public class MealServiceImplTest {

    private MealServiceImpl service;
    private MealRepository repository;

    @Before
    public void setUp() {
        service = new MealServiceImpl();
        repository = createMock(MealRepository.class);
        Whitebox.setInternalState(service, "mealRepository", repository);
    }

    @Test
    public void getAll() {
        expect(repository.getAll()).andReturn(new ArrayList<>());
        replay(repository);
        service.getAll();
        verify(repository);
    }
}
