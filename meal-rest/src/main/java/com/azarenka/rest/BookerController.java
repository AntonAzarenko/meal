package com.azarenka.rest;

import com.azarenka.domain.Booker;
import com.azarenka.service.impl.BookerService;
import com.azarenka.service.response.BookerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/booker")
public class BookerController {

    @Autowired
    private BookerService bookerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Booker> getBookerByEmail() {
        return bookerService.getByUserEmail();
    }

    @PostMapping
    public void save(@RequestBody BookerResponse bookerResponse) {
        bookerService.save(bookerResponse.asBooker());
    }

    @GetMapping(value = "/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String price(@PathVariable("category") String category) {
        return bookerService.getPriceByCategory(category);
    }
}
