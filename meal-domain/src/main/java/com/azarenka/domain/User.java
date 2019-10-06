package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;
import java.util.Set;

/**
 * User
  * <p>
 *  (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnko
 * Date: 21.07.2019
 */
public class User extends BaseEntity {

    private String email;
    private String password;
    private String name;
    private boolean enabled = false;
    private Set<Role> roles;
    private String avatar;
    private String activateCode;
    private Date registrationDate = new Date();
    /**
     * Gets registration date.
     *
     * @return registration date.
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets registration date.
     *
     * @param registrationDate registration date.
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Gets activate code.
     *
     * @return activate code.
     */
    public String getActivateCode() {
        return activateCode;
    }

    /**
     * Sets activate code.
     *
     * @param activateCode activate code.
     */
    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    /**
     * Gets user email.
     *
     * @return user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email email.
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * Check is enable user.
     *
     * @return true or false.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets user enabled.
     *
     * @param enabled user enabled.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets user role.
     *
     * @return user role.
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles roles.
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Gets user avatar.
     *
     * @return user avatar.
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Sets avatar.
     *
     * @param avatar avatar.
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(enabled, user.enabled)
                .append(email, user.email)
                .append(password, user.password)
                .append(name, user.name)
                .append(activateCode, user.activateCode)
                .append(roles, user.roles)
                .append(avatar, user.avatar)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(email)
                .append(password)
                .append(name)
                .append(enabled)
                .append(activateCode)
                .append(roles)
                .append(avatar)
                .toHashCode();
    }
}
