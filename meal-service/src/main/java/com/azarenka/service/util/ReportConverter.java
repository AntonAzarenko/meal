package com.azarenka.service.util;

import com.azarenka.domain.CheckType;
import com.azarenka.domain.Report;

import java.math.BigDecimal;

public class ReportConverter {

    public static CheckType getCheckType(String category) {
        switch (category) {
            case "FOOD":
                return CheckType.FOOD;
            case "DRINK":
                return CheckType.DRINK;
            case "GAS":
                return CheckType.GAS;
            case "CLOTHES":
                return CheckType.CLOTHES;
            case "HOME":
                return CheckType.HOME;
            case "CREDIT":
                return CheckType.CREDIT;
            case "PETS":
                return CheckType.PETS;
        }
        return null;
    }

    public static void setField(CheckType type, BigDecimal decimal, Report report) {
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
            case HOME:
                report.setHome(decimal);
                break;
            case CREDIT:
                report.setCredit(decimal);
                break;
            case PETS:
                report.setPets(decimal);
                break;
        }
    }
}
