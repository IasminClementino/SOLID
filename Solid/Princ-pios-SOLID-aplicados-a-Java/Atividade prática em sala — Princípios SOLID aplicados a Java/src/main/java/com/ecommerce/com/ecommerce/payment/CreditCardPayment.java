package com.ecommerce.payment;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Pagando com cartão de crédito: " + amount);
    }
}