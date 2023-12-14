package lk.isuri.devhub.paymentservice.service;

import lk.isuri.devhub.paymentservice.payload.request.PaymentRequest;
import lk.isuri.devhub.paymentservice.payload.response.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}