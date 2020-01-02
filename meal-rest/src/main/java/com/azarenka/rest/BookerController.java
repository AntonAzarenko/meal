package com.azarenka.rest;

import com.azarenka.domain.Booker;
import com.azarenka.domain.Report;
import com.azarenka.service.impl.BookerService;
import com.azarenka.service.response.BookerResponse;
import com.azarenka.service.response.OutComeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public void save(@RequestBody @Validated BookerResponse bookerResponse) {
        bookerService.save(bookerResponse.asBooker());
    }

    @GetMapping(value = "/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String price(@PathVariable("category") String category) {
        return bookerService.getPriceByCategory(category);
    }

    @GetMapping(value = "/report/{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Report getReportOfMonth(@PathVariable("year") String year,
                                   @PathVariable("month") String month) {
        return bookerService.getReport(year, month);
    }

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public Report findCurrentReport() {
        LocalDate date = LocalDate.now();
        return bookerService.getReport(String.valueOf(date.getYear()), String.valueOf(date.getMonth().ordinal()+1));
    }

    @GetMapping(value = "/outcome/{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OutComeResponse> getOutcomes(@PathVariable("year") String year,
                                             @PathVariable("month") String month) {
        return bookerService.getOutcome(year, month);
    }
}
