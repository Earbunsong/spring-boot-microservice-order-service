package co.dev.kh.orderservice.service;

import co.dev.kh.orderservice.entity.Order;
import co.dev.kh.orderservice.model.OrderRequest;
import co.dev.kh.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public Long placeOrder(OrderRequest orderRequest) {
//Order Entity -> Save the data with Status Order  Created
//Product Service -> Reduce the quantity of product
//Payment service -> Payment ->Success -> Complete, Else
//        CANCELLED

        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .status("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();
        order = orderRepository.save(order);
        return order.getId();
    }
}
