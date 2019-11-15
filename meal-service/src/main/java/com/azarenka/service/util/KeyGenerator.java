package com.azarenka.service.util;

import java.util.UUID;

/**
 * Base class utils.
 *
 * Date: 21.07.2019
 *
 * @author Anton Azarenka
 */
public class KeyGenerator {

    /**
     * Default constructor.
     */
    public KeyGenerator() {

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
