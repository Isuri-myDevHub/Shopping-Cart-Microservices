package lk.isuri.devhub.orderservice.service;

import lk.isuri.devhub.orderservice.payload.request.OrderRequest;
import lk.isuri.devhub.orderservice.payload.response.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
