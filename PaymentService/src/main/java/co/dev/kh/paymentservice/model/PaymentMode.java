package co.dev.kh.paymentservice.model;

import lombok.Builder;


public enum PaymentMode {
    CASH,
    PAYPAL,
    DEBIT_CARD,
    CREDIT_CARD,
    APPLE_PAY
}
