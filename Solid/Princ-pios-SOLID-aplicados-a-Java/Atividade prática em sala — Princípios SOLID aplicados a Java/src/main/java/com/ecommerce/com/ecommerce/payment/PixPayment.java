package com.ecommerce.payment;

public class PixPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Pagando com PIX: " + amount);
    }
}