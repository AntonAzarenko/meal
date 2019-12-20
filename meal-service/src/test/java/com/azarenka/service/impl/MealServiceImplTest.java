package com.azarenka.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.azarenka.repository.MealRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class MealServiceImplTest {
    @InjectMocks
    private MealServiceImpl service = new MealServiceImpl();
    @Mock
    private MealRepository repository;


    @Test
    public void getAll() {
        when(repository.getAll()).thenReturn(Collections.emptyList());
        service.getAll();
        verify(repository).getAll();
    }
}
