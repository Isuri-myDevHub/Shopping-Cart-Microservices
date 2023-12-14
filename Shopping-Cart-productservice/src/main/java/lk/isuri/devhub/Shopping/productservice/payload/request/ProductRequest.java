package lk.isuri.devhub.Shopping.productservice.payload.request;

import lombok.Builder;
import lombok.Data;


 // ProductRequest class represents the structure of the request for creating or updating a product.

@Data
@Builder
public class ProductRequest {
    private String name;        // Name of the product
    private long price;         // Price of the product
    private long quantity;      // Quantity of the product
}
