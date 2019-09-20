package com.azarenka.api;

import com.azarenka.Menu;
import com.azarenka.response.MenuResponse;

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
     * @param foodId food id
     * @param dayId  day id
     * @param mealId meal id
     * @param count  count
     */
    void createMenu(String foodId, String dayId, String mealId, int count, String title);

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
}
