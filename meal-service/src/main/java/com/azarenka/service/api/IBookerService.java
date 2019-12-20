package com.azarenka.service.api;

import com.azarenka.domain.Booker;
import com.azarenka.domain.Report;

import java.util.List;

public interface IBookerService {

    List<Booker> getByUserEmail();

    void save(Booker booker);

    String getPriceByCategory(String category);

    Report getReport();
}
