package com.azarenka.repository.api;

import com.azarenka.domain.Menu;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Menu repository interface
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
@Repository
public interface MenuRepository {

    /**
     * Returns all menu by user id
     * @param userId user ID
     * @return list of  menu
     */
    List<Menu> getMenu(@Param("userId") String userId);

    /**
     * Saves menu.
     *
     * @param menu menu
     */
    void save(Menu menu);
}
