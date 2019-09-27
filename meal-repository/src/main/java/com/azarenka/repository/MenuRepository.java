package com.azarenka.repository;

import com.azarenka.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
@Mapper
public interface MenuRepository {

    /**
     * Returns all menu by user id
     *
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

    /**
     * Removes by id
     *
     * @param id id
     */
    void remove(String id);

    /**
     * Returns names of all menu for current user
     *
     * @param id
     * @return
     */
    List<String> getMenuNames(String id);
}
