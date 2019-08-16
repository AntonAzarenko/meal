package com.azarenka.service.api;

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
     * @param foodId food id
     * @param dayId day id
     * @param mealId meal id
     * @param count count
     */
    void createMenu(String foodId, String dayId, String mealId, int count,  String title);

}
