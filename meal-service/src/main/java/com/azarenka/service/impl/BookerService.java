package com.azarenka.service.impl;

import com.azarenka.domain.Booker;
import com.azarenka.domain.CheckType;
import com.azarenka.domain.Report;
import com.azarenka.repository.BookerRepository;
import com.azarenka.service.api.IBookerService;
import com.azarenka.service.impl.auth.UserPrinciple;
import com.azarenka.service.util.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
            if (element.getType().equals(getCheckType(category))) {
                price = price.add(element.getCountPrice());
            }
        }
        System.out.println(price);
        return price.toString();
    }

    @Override
    public Report getReport() {
        List<Booker> all = bookerRepository.getAllByUserEmail(UserPrinciple.safeGet().getUsername());
        Map<CheckType, BigDecimal> checkTypeBigDecimalMap = convertAllBookersToMap(all);
        Report report = new Report();
        checkTypeBigDecimalMap.forEach((k, v) -> {
            setField(k, v, report);
        });
        return report;
    }

    private Map<CheckType, BigDecimal> convertAllBookersToMap(List<Booker> all) {
        Map<CheckType, BigDecimal> map = new HashMap<>();
        all.forEach(element -> {
            map.merge(element.getType(), element.getCountPrice(), (old, neW) -> old.add(neW));
        });
        return map;
    }

    private void setField(CheckType type, BigDecimal decimal, Report report) {
        switch (type) {
            case FOOD:
                report.setFood(decimal);
                break;
            case DRINK:
                report.setAlcohol(decimal);
                break;
            case GAS:
                report.setGas(decimal);
                break;
            case CLOTHES:
                report.setClothes(decimal);
                break;
        }
    }

    private CheckType getCheckType(String category) {
        switch (category) {
            case "FOOD":
                return CheckType.FOOD;
            case "DRINK":
                return CheckType.DRINK;
            case "GAS":
                return CheckType.GAS;
            case "CLOTHES":
                return CheckType.CLOTHES;
        }
        return null;
    }
}
