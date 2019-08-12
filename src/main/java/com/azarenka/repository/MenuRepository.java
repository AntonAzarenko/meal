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

    List<Menu> getMenu(@Param("userId") String userId);
}
