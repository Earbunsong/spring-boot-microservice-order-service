package co.dev.kh.orderservice.external.client;

import co.dev.kh.orderservice.exception.CustomException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment",url = "${microservice.payment}")
public interface PaymentService {
    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentService paymentService);
    default ResponseEntity<Long> fallback(Exception ex) {
        throw new CustomException("Payment Service is not available",
                "UNAVAILABLE",
                500);
    }
}
