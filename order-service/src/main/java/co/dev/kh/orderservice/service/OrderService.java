package co.dev.kh.orderservice.service;

import co.dev.kh.orderservice.model.OrderRequest;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
}
