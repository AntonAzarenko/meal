package com.azarenka.service.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.azarenka.domain.Food;
import com.azarenka.repository.FoodRepository;
import com.azarenka.service.api.FoodService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class FoodServiceImplTest {
    @InjectMocks
    private FoodService service = new FoodServiceImpl();
    @Mock
    private FoodRepository repository;

    @Test
    public void testGetFoods() {
        expect(repository.findAll()).andReturn(new ArrayList<Food>());
        replay(repository);
        service.getFoods();
        verify(repository);
    }
}
