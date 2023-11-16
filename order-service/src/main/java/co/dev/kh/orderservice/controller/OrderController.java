package co.dev.kh.orderservice.controller;

import co.dev.kh.orderservice.model.OrderRequest;
import co.dev.kh.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/placeholder")
    public ResponseEntity<Long> placeHolderOrder(@RequestBody OrderRequest orderRequest){
        Long orderId = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderId, HttpStatusCode.valueOf(HttpStatus.SC_OK));
    }
}
