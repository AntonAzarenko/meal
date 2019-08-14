package com.azarenka.service.auth;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RegistrationUser {

    @NonNull
    private String name;
    @NonNull
    private String login;
    @NonNull
    private String password;

    /**
     * Gets user login.
     *
     * @return user login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets user password.
     *
     * @return user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets user name.
     *
     * @return user name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
