package co.dev.kh.productservice.service;

import co.dev.kh.productservice.model.ProductRequest;
import co.dev.kh.productservice.model.ProductResponse;

public interface ProductService {
    Long createProduct(ProductRequest productRequest);
    ProductResponse getProductById(Long productId);
    void reduceQuantity(long productId, long quantity);
}
