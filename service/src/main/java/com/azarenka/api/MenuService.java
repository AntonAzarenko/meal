package com.azarenka.api;

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
}
