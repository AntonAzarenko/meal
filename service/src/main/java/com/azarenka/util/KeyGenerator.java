package com.azarenka.util;

import java.util.UUID;

/**
 * Base class utils.
 * <p>
 * Copyright (C) 2018 epam.com
 * <p>
 * Date: 21.07.2019
 *
 * @author Anton Azarenka
 */
public final class KeyGenerator {

    /**
     * Default constructor.
     */
    private KeyGenerator() {
        throw new AssertionError("Utility class");
    }

    /**
     * Set value id.
     *
     * @return {@link String}
     */
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
