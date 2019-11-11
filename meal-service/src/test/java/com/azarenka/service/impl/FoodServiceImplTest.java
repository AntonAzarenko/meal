package com.azarenka.service.impl;

import com.azarenka.domain.Food;
import com.azarenka.repository.FoodRepository;
import com.azarenka.service.api.FoodService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;

@RunWith(MockitoJUnitRunner.class)
public class FoodServiceImplTest {

    private FoodService service;
    private FoodRepository repository;

    @Before
    public void setUp() {
        service = new FoodServiceImpl();
        repository = createMock(FoodRepository.class);
        Whitebox.setInternalState(service, "foodRepository", repository);
    }

    @Test
    public void testGetFoods() {
        expect(repository.findAll()).andReturn(new ArrayList<Food>());
        replay(repository);
        service.getFoods();
        verify(repository);
    }
}
