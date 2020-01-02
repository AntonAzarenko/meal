package com.azarenka.service.api;

import com.azarenka.domain.Booker;
import com.azarenka.domain.Report;
import com.azarenka.service.response.OutComeResponse;

import java.util.List;

public interface IBookerService {

    List<Booker> getByUserEmail();

    void save(Booker booker);

    String getPriceByCategory(String category);

    Report getReport(String month, String year);

    List<OutComeResponse> getOutcome(String year, String month);
}
