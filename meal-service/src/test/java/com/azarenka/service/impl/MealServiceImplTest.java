package com.azarenka.service.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.azarenka.repository.MealRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class MealServiceImplTest {
    @InjectMocks
    private MealServiceImpl service = new MealServiceImpl();
    @Mock
    private MealRepository repository;


    @Test
    public void getAll() {
        expect(repository.getAll()).andReturn(new ArrayList<>());
        replay(repository);
        service.getAll();
        verify(repository);
    }
}
