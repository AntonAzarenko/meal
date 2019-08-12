package com.azarenka.service.impl;

import com.azarenka.auth.LoggedUser;
import com.azarenka.domain.Menu;
import com.azarenka.repository.MenuRepository;
import com.azarenka.response.MenuResponse;
import com.azarenka.service.api.MenuService;
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
