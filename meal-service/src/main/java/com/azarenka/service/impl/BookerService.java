package com.azarenka.service.impl;

import com.azarenka.domain.Booker;
import com.azarenka.domain.CheckType;
import com.azarenka.domain.Report;
import com.azarenka.repository.BookerRepository;
import com.azarenka.service.api.IBookerService;
import com.azarenka.service.impl.auth.UserPrinciple;
import com.azarenka.service.util.KeyGenerator;
import com.azarenka.service.util.ReportConverter;
import com.azarenka.service.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        LocalDate date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
        List<Booker> all = bookerRepository.getAllByEmailAndDate("", UserPrinciple.safeGet().getUsername());
        Map<CheckType, BigDecimal> checkTypeBigDecimalMap = convertAllBookersToMap(all);
        Report report = new Report();
        checkTypeBigDecimalMap.forEach((k, v) -> {
            ReportConverter.setField(k, v, report);
        });
        report.setYear(year);
        report.setProfit(countProfit(report));
        report.setMonth(TimeUtil.getMonth(date));
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

    private Map<CheckType, BigDecimal> convertAllBookersToMap(List<Booker> all) {
        Map<CheckType, BigDecimal> map = new HashMap<>();
        all.forEach(element -> {
            map.merge(element.getType(), element.getCountPrice(), (old, neW) -> old.add(neW));
        });
        return map;
    }
}
