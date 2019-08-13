package com.azarenka.api;

import com.azarenka.User;
import com.azarenka.auth.RegistrationUser;

/**
 * User service
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 21.07.2019
 *
 * @author Anton Azarnko
 */
public interface UserService {

    /**
     * Saves user.
     *
     * @param user user.
     */
    void save(RegistrationUser user);

    /**
     * Returns user by email.
     *
     * @param email email.
     * @return {@link User}.
     */
    User getByEmail(String email);

    /**
     * Returns name of current user.
     *
     * @return name;
     */
    String getUserName();

    /**
     * Returns is activate user
     *
     * @param code code.
     */
    boolean isActivate(String code);
}
