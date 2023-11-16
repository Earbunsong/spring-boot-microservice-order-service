package co.dev.kh.orderservice.external.client;

import co.dev.kh.orderservice.exception.CustomException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product",url = "${microservice.product}")
public interface ProductService {
    @PutMapping("/reduceQuantity/{id}")
    ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId,
            @RequestParam long quantity
    );
    default ResponseEntity<Void> fallback(Exception ex) {
        throw new CustomException("Product Service is not available",
                "UNAVAILABLE",
                500);
    }
}
