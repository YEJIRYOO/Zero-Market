package com.likelion.zeroMarket.store;

import com.likelion.zeroMarket.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByAddress(String address);
}
