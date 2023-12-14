package lk.isuri.devhub.Shopping.productservice.service;

import lk.isuri.devhub.Shopping.productservice.payload.request.ProductRequest;
import lk.isuri.devhub.Shopping.productservice.payload.response.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);

    public void deleteProductById(long productId);
}