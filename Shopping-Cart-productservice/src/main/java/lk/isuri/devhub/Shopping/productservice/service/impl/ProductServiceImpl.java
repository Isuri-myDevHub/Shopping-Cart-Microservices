package lk.isuri.devhub.Shopping.productservice.service.impl;

import lk.isuri.devhub.Shopping.productservice.entity.Product;
import lk.isuri.devhub.Shopping.productservice.exception.ProductServiceCustomException;
import lk.isuri.devhub.Shopping.productservice.payload.request.ProductRequest;
import lk.isuri.devhub.Shopping.productservice.payload.response.ProductResponse;
import lk.isuri.devhub.Shopping.productservice.repository.ProductRepository;
import lk.isuri.devhub.Shopping.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // Method to add a new product
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("ProductServiceImpl | addProduct is called");

        // Create a new Product object from the request
        Product product = Product.builder().productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        // Save the product to the repository
        product = productRepository.save(product);

        log.info("ProductServiceImpl | addProduct | Product Created");
        log.info("ProductServiceImpl | addProduct | Product Id : " + product.getProductId());
        return product.getProductId();
    }

    // Method to get product details by ID
    @Override
    public ProductResponse getProductById(long productId) {

        log.info("ProductServiceImpl | getProductById is called");
        log.info("ProductServiceImpl | getProductById | Get the product for productId: {}", productId);

        // Retrieve the product from the repository by ID
        Product product
                = productRepository.findById(productId)
                .orElseThrow(
                        () -> new ProductServiceCustomException("Product with given Id not found","PRODUCT_NOT_FOUND"));

        // Create a ProductResponse object and copy properties from the retrieved product
        ProductResponse productResponse
                = new ProductResponse();

        copyProperties(product, productResponse);

        log.info("ProductServiceImpl | getProductById | productResponse :" + productResponse.toString());

        return productResponse;
    }

    // Method to reduce the quantity of a product
    @Override
    public void reduceQuantity(long productId, long quantity) {

        log.info("Reduce Quantity {} for Id: {}", quantity,productId);

        // Retrieve the product from the repository by ID
        Product product
                = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException(
                        "Product with given Id not found",
                        "PRODUCT_NOT_FOUND"
                ));

        // Check if the product has sufficient quantity
        if(product.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }
        // Update the quantity and save the product
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");
    }

    // Method to delete a product by ID
    @Override
    public void deleteProductById(long productId) {
        log.info("Product id: {}", productId);

        // Check if the product exists in the repository
        if (!productRepository.existsById(productId)) {
            log.info("Im in this loop {}", !productRepository.existsById(productId));
            throw new ProductServiceCustomException(
                    "Product with given with Id: " + productId + " not found:",
                    "PRODUCT_NOT_FOUND");
        }
        // Delete the product by ID
        log.info("Deleting Product with id: {}", productId);
        productRepository.deleteById(productId);

    }
}