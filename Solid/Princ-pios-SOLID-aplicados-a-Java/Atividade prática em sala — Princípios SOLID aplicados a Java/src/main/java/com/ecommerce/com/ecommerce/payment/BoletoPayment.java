package com.ecommerce.payment;

public class BoletoPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Pagando com boleto: " + amount);
    }
}