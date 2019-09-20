package com.azarenka;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoFieldShadowingRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utils class.
 * <p>
 * Copyright (C) 2018 Azarenka.com
 * <p>
 * Date: Oct 22, 2018
 *
 * @author Anton Azarenka
 */
public final class TestUtils {

    private static final String CONSTRUCTOR_ERROR_MESSAGE = "Instantiation via private constructor is forbidden.";

    private static Validator validator = ValidatorBuilder.create()
        .with(new GetterMustExistRule())
        .with(new NoFieldShadowingRule())
        .with(new NoStaticExceptFinalRule())
        .with(new SetterTester())
        .with(new GetterTester())
        .build();

    /**
     * Default constructor.
     */
    private TestUtils() {
        throw new AssertionError(CONSTRUCTOR_ERROR_MESSAGE);
    }

    @Test
    public static void testPojoStructureAndBehavior(List<Class> classes) {
        List<PojoClass> pojoClasses = classes.stream().map(PojoClassFactory::getPojoClass).collect(Collectors.toList());
        validator.validate(pojoClasses);
    }
}
