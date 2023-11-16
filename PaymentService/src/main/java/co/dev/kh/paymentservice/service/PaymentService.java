package co.dev.kh.paymentservice.service;

import co.dev.kh.paymentservice.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
