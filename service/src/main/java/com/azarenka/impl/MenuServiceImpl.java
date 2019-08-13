package com.azarenka.impl;

import com.azarenka.Menu;
import com.azarenka.api.MenuRepository;
import com.azarenka.api.MenuService;
import com.azarenka.auth.LoggedUser;
import com.azarenka.response.MenuResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Menu service
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuResponse> getMenu() {
        String userId = LoggedUser.getId();
        List<Menu> menuList = menuRepository.getMenu(userId);
        return null;
    }
}
