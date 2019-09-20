package com.azarenka;


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
            Arrays.asList(User.class));
    }

    @Test
    public void testEquals() {
        Arrays.asList(User.class)
            .forEach(
                clazz -> EqualsVerifier.forClass(clazz).suppress(Warning.NONFINAL_FIELDS).usingGetClass().verify());
    }
}
