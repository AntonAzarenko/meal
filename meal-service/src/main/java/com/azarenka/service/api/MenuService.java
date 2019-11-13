package com.azarenka.service.api;

import com.azarenka.domain.Menu;
import com.azarenka.service.response.MenuResponse;

import java.util.List;

/**
 * Menu service interface
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
public interface MenuService {

    /**
     * Gets new menu current user.
     *
     * @return list of menu.
     */
    List<MenuResponse> getMenu();

    /**
     * Creates and saves detail of menu
     *
     * @param menuResponse
     */
    void save(MenuResponse menuResponse);

    /**
     * Removes element from menu table by id
     *
     * @param id id
     */
    void remove(String id);

    /**
     * @return names of menus
     */
    List<String> getMenuNames(List<Menu> menus);

    /**
     * @return menu by name
     */
    List<MenuResponse> getMenuByName(String name);
}
