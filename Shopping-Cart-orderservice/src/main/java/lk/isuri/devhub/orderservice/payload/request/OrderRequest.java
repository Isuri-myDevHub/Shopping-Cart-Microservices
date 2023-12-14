package lk.isuri.devhub.orderservice.payload.request;

import lk.isuri.devhub.orderservice.utils.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    private long productId;
    private long totalAmount;
    private long quantity;
    private PaymentMode paymentMode;
}