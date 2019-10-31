package com.azarenka.service;


import com.azarenka.domain.BaseEntity;
import com.azarenka.domain.Day;
import com.azarenka.domain.Food;
import com.azarenka.domain.Meal;
import com.azarenka.domain.Menu;
import com.azarenka.domain.User;

import org.junit.Test;

import java.util.Arrays;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * Verifies domain.
 * <p>
 * Copyright (C) 2018 Azarenka.com
 * <p>
 * Date: Oct 22, 2018
 *
 * @author Anton Azarenka
 */
public class DomainVerifierTest {

    @Test
    public void testPojoStructureAndBehavior() {
        TestUtils.testPojoStructureAndBehavior(
            Arrays.asList(Day.class, BaseEntity.class, Food.class, Meal.class, Menu.class, User.class));
    }

    @Test
    public void testEquals() {
        Arrays.asList(Day.class, BaseEntity.class, Food.class, Meal.class, Menu.class, User.class)
            .forEach(
                clazz -> EqualsVerifier.forClass(clazz).suppress(Warning.NONFINAL_FIELDS).usingGetClass().verify());
    }
}
