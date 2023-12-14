package lk.isuri.devhub.Shopping.productservice.controller;

import lk.isuri.devhub.Shopping.productservice.payload.request.ProductRequest;
import lk.isuri.devhub.Shopping.productservice.payload.request.ProductResponse;
import lk.isuri.devhub.Shopping.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Log4j2
public class ProductController {

    private final ProductService productService;

    // Endpoint to add a new product
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {

        log.info("ProductController | addProduct is called");

        log.info("ProductController | addProduct | productRequest : " + productRequest.toString());

        // Call the ProductService to add a new product
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    // Endpoint to get product details by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {

        log.info("ProductController | getProductById is called");

        log.info("ProductController | getProductById | productId : " + productId);

        // Call the ProductService to get product details by ID
        ProductResponse productResponse
                = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    // Endpoint to reduce the quantity of a product
    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId,
            @RequestParam long quantity
    ) {

        log.info("ProductController | reduceQuantity is called");

        log.info("ProductController | reduceQuantity | productId : " + productId);
        log.info("ProductController | reduceQuantity | quantity : " + quantity);

        // Call the ProductService to reduce the quantity of a product
        productService.reduceQuantity(productId,quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint to delete a product by ID
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") long productId) {
        // Call the ProductService to delete a product by ID
        productService.deleteProductById(productId);
    }
}