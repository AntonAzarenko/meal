package com.azarenka.repository.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * User repository.
 * <p>
 * (c) ant-azarenko@mail.ru
 * <p>
 * <p>
 * Date 21.07.2019
 * <p>
 * author Anton Azarenka
 */
@Repository
public interface UsersRoleMapRepository {

    /**
     * Writes role of user.
     *
     * @param userId user id.
     * @param roleId role id.
     */
    void saveRole(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * Returns role id by user role.
     *
     * @return role id.
     */
    String getIdByRole(@Param("role") String role);
}
