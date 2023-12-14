package lk.isuri.devhub.Shopping.productservice.repository;

import lk.isuri.devhub.Shopping.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
