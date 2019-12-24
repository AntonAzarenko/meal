package com.azarenka.rest;

import com.azarenka.domain.Booker;
import com.azarenka.domain.Report;
import com.azarenka.service.impl.BookerService;
import com.azarenka.service.response.BookerResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  /*  @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public Report getReport() {
        return bookerService.getReport();
    }*/

    @GetMapping(value = "/report/{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Report getReportOfMonth(@PathVariable("year") String year, @PathVariable("month") String month) {
        return bookerService.getReport(year, month);
    }
}
