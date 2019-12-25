package com.azarenka.service.impl;

import com.azarenka.domain.Booker;
import com.azarenka.domain.CheckType;
import com.azarenka.domain.Report;
import com.azarenka.repository.BookerRepository;
import com.azarenka.service.api.IBookerService;
import com.azarenka.service.impl.auth.UserPrinciple;
import com.azarenka.service.util.KeyGenerator;
import com.azarenka.service.util.ReportConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookerService implements IBookerService {

    @Autowired
    BookerRepository bookerRepository;

    @Override
    public List<Booker> getByUserEmail() {
        String userEmail = UserPrinciple.safeGet().getUsername();
        return bookerRepository.getAllByUserEmail(userEmail);
    }

    @Override
    public void save(Booker booker) {
        booker.setId(KeyGenerator.generateUuid());
        booker.setUserEmail(UserPrinciple.safeGet().getEmail());
        bookerRepository.save(booker);
    }

    @Override
    public String getPriceByCategory(String category) {
        String userEmail = UserPrinciple.safeGet().getUsername();
        List<Booker> all = bookerRepository.getAllByUserEmail(userEmail);
        BigDecimal price = BigDecimal.ZERO;
        for (Booker element : all) {
            if (element.getType().equals(ReportConverter.getCheckType(category))) {
                price = price.add(element.getCountPrice());
            }
        }
        System.out.println(price);
        return price.toString();
    }

    @Override
    public Report getReport(String month, String year) {
        List<LocalDate> dates = createAllDates(year, month);
        List<Booker> all = bookerRepository.getAllByUserEmail(UserPrinciple.safeGet().getUsername());
        List<Booker> filteredBookers = new ArrayList<>();
        dates.forEach(date -> {
            filteredBookers.addAll(all.stream().filter(booker -> booker.getCheckDate().equals(date)).collect(Collectors.toList()));
        });
        Map<CheckType, BigDecimal> checkTypeBigDecimalMap = convertAllBookersToMap(filteredBookers);
        Report report = new Report();
        checkTypeBigDecimalMap.forEach((k, v) -> {
            ReportConverter.setField(k, v, report);
        });
        report.setYear(year);
        report.setProfit(countProfit(report));
        report.setMonth(month);
        return report;
    }

    private BigDecimal countProfit(Report report) {
        BigDecimal profit = new BigDecimal("0.00");
        profit = profit.add(report.getFood());
        profit = profit.add(report.getAlcohol());
        profit = profit.add(report.getClothes());
        profit = profit.add(report.getCredit());
        profit = profit.add(report.getGas());
        profit = profit.add(report.getHome());
        profit = profit.add(report.getPets());
        return profit;
    }

    private List<LocalDate> createAllDates(String month, String year) {
        LocalDate date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
        List<LocalDate> dates = new ArrayList<>();
        IntStream.range(1, date.lengthOfMonth()).forEach(i -> {
            dates.add(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), i));
        });
        return dates;
    }

    private Map<CheckType, BigDecimal> convertAllBookersToMap(List<Booker> all) {
        Map<CheckType, BigDecimal> map = new HashMap<>();
        all.forEach(element -> {
            map.merge(element.getType(), element.getCountPrice(), (old, neW) -> old.add(neW));
        });
        return map;
    }
}
