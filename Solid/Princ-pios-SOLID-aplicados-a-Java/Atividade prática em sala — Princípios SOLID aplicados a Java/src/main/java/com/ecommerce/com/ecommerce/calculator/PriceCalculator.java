package com.ecommerce.calculator;

import java.util.List;

public class PriceCalculator {

    public double calculateTotal(List<String> items) {
        double total = 0;
        for (String item : items) {
            total += 10.0; // valor fixo só pra exemplo
        }
        return total;
    }
}