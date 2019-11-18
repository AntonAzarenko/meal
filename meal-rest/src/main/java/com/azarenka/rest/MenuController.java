package com.azarenka.rest;

import com.azarenka.domain.auth.ResponseMessage;
import com.azarenka.service.api.MenuService;
import com.azarenka.service.response.MenuResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Menu  controller
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnka
 * Date 21 07 2019
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/menu")
public class MenuController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody MenuResponse menuResponse) {
        menuService.save(menuResponse);
        return new ResponseEntity<>(new ResponseMessage("Food was added to menu"), HttpStatus.OK);
    }

    @GetMapping(value ="/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuResponse> getMenuByName(@PathVariable("name") String name){
       return menuService.getMenuByName(name);
    }

    @GetMapping(value ="/findallMenu", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getMenuByName(){
        return menuService.getMenuByUsername();
    }
}
