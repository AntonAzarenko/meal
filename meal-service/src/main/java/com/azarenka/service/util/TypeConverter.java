package com.azarenka.service.util;

import com.azarenka.domain.CheckType;
import com.azarenka.domain.Report;

import java.math.BigDecimal;

public class TypeConverter {

    //TODO replace ALL methods  with MAP
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

    public static String getTypeToString(CheckType type) {
        switch (type) {
            case FOOD:
                return "Еда";
            case DRINK:
                return "Алкоголь";
            case GAS:
                return "Бензин";
            case CLOTHES:
                return "Одежда";
            case HOME:
                return "Дом";
            case CREDIT:
                return "Кредит";
            case PETS:
                return "Животные";
        }
        return null;
    }

    public static String getTypeOfIcon(CheckType type) {
        switch (type) {
            case FOOD:
                return "shopping_cart";
            case DRINK:
                return "local_bar";
            case GAS:
                return "local_gas_station";
            case CLOTHES:
                return "accessibility";
            case HOME:
                return "home";
            case CREDIT:
                return "local_atm";
            case PETS:
                return "pets";
        }
        return null;
    }
}
