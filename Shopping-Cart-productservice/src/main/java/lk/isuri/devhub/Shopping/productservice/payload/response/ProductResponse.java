package lk.isuri.devhub.Shopping.productservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


 // ProductResponse class represents the structure of the response for product-related operations.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String productName;  // Holds the name of the product
    private long productId;      // Unique identifier for the product
    private long quantity;       // Quantity of the product
    private long price;          // Price of the product
}
