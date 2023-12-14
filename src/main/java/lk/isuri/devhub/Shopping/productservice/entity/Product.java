package lk.isuri.devhub.Shopping.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


 // Product class represents the entity for a product in the shopping application.

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;         // Unique identifier for the product

    @Column(name = "PRODUCT_NAME")
    private String productName;     // Name of the product

    @Column(name = "PRICE")
    private long price;             // Price of the product

    @Column(name = "QUANTITY")
    private long quantity;          // Quantity of the product
}
