package co.dev.kh.paymentservice.service;

import co.dev.kh.paymentservice.entity.TransactionDetails;
import co.dev.kh.paymentservice.model.PaymentRequest;
import co.dev.kh.paymentservice.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
@Log4j2
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);

        TransactionDetails transactionDetails
                = TransactionDetails.builder()
                .id(paymentRequest.getOrderId())
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();

        paymentRepository.save(transactionDetails);

        log.info("Transaction Completed with Id: {}", transactionDetails.getId());

        return transactionDetails.getId();
    }
}
