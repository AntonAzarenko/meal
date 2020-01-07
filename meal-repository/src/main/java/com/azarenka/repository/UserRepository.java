package com.azarenka.repository;

import com.azarenka.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * User repository.
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnko
 * Date 21.07.2019
 */
@Mapper
public interface UserRepository {

    /**
     * Saves user.
     *
     * @param user user.
     */
    void save(User user);

    /**
     * Gets user by login
     *
     * @param email login
     * @return user.
     */
    User getByEmail(@Param("email") String email);

    /**
     * @param email
     * @return
     */
    Optional<User> getOptionalByEmail(String email);

    /**
     * Returns user.
     *
     * @param code code.
     * @return user.
     */
    User getByActivateCode(String code);

    /**
     * Updates user.
     *
     * @param id      user id.
     * @param enabled true or false.
     */
    void updateActivationCode(@Param("id") String id, @Param("enabled") boolean enabled);

    /**
     *
     * @param user
     */
    void update(User user);

    /**
     * This method take all users for send email.
     *
     * @return users {@link User}
     */
    List<User> getAll();
}
