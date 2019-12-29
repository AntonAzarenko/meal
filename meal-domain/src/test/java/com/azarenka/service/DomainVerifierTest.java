package com.azarenka.service;


import com.azarenka.domain.*;

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
            Arrays.asList(Day.class, BaseEntity.class, Food.class, Meal.class, Menu.class, User.class, Booker.class,
                    Filter.class, Report.class));
    }

    @Test
    public void testEquals() {
        Arrays.asList(Day.class, BaseEntity.class, Food.class, Meal.class, Menu.class, User.class, Booker.class,
                Filter.class, Report.class)
            .forEach(
                clazz -> EqualsVerifier.forClass(clazz).suppress(Warning.NONFINAL_FIELDS).usingGetClass().verify());
    }
}
