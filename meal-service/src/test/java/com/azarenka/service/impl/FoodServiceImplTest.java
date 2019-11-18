package com.azarenka.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.azarenka.repository.FoodRepository;
import com.azarenka.service.api.FoodService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class FoodServiceImplTest {
    @InjectMocks
    private FoodService service = new FoodServiceImpl();
    @Mock
    private FoodRepository repository;

    @Test
    public void testGetFoods() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        service.getFoods();
        verify(repository).findAll();
    }
}
