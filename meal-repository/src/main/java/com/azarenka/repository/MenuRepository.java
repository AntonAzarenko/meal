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

    /**
     * Returns menu list by user email and menu title
     *
     * @param title    menu title
     * @param userName user email
     * @return list of menu
     */
    List<Menu> getMenuByUsernameAndMenuTitle(@Param("userName") String userName, @Param("title") String title);

    /**
     * @param userName
     * @param title
     * @param dayId
     * @return
     */
    List<Menu> getMenuByUsernameAndMenuTitleAndDay(@Param("userName") String userName, @Param("title") String title, @Param("dayId") String dayId);

    /**
     * Returns menu list by user email.
     *
     * @param userName
     * @return
     */
    List<String> findMenuByUserName(String userName);

    List<Menu> findMenuByFilter(@Param("userName") String userName,
                                @Param("title") String title,
                                @Param("day") String day,
                                @Param("meal") String meal);
}
