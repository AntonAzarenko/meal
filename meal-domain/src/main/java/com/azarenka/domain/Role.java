package com.azarenka.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Roles
 * <p>
 * Copyright (C) ant-azarenko@mail.ru
 * </p>
 * Date 21.07.2019
 *
 * @author Anton Azarnko
 */
public enum  Role  implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
