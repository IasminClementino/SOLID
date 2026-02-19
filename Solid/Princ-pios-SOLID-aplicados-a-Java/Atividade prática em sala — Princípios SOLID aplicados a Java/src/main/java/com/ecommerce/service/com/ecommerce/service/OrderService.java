package com.ecommerce.service;

import com.ecommerce.calculator.PriceCalculator;
import com.ecommerce.payment.*;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.notification.EmailNotification;

import java.util.List;

public class OrderService {

    private final PriceCalculator calculator = new PriceCalculator();
    private final OrderRepository repository = new OrderRepository();
    private final EmailNotification notification = new EmailNotification();

    public void processOrder(String customerEmail, List<String> items, String paymentType) {

        double total = calculator.calculateTotal(items);

        PaymentProcessor paymentProcessor = createPaymentProcessor(paymentType);
        paymentProcessor.pay(total);

        repository.save();

        notification.send(customerEmail);
    }

    private PaymentProcessor createPaymentProcessor(String paymentType) {
        switch (paymentType.toLowerCase()) {
            case "credit":
                return new CreditCardPayment();
            case "pix":
                return new PixPayment();
            case "boleto":
                return new BoletoPayment();
            default:
                throw new IllegalArgumentException("Tipo de pagamento inválido");
        }
    }
}