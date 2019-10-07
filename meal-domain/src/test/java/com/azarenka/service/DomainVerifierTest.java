package com.azarenka.service;


import org.junit.Test;

import java.util.Arrays;

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
            Arrays.asList());
    }

    @Test
    public void testEquals() {
       /* Arrays.asList(User.class)
            .forEach(
                clazz -> EqualsVerifier.forClass(clazz).suppress(Warning.NONFINAL_FIELDS).usingGetClass().verify());*/
    }
}
