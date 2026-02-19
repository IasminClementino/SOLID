package com.ecommerce;

import com.ecommerce.service.OrderService;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        List<String> items = Arrays.asList("Produto1", "Produto2", "Produto3");

        orderService.processOrder(
                "cliente@email.com",
                items,
                "pix" // credit | pix | boleto
        );
    }
}