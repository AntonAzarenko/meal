package com.azarenka.api;

import com.azarenka.Menu;

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

    List<Menu> getMenu(@Param("userId") String userId);
}
