package com.likelion.zeroMarket.product;

import com.likelion.zeroMarket.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStoreAndCategory(Store store, String category);
}
