package com.likelion.zeroMarket;

import com.likelion.zeroMarket.exception.DataNotFoundException;
import com.likelion.zeroMarket.product.Product;
import com.likelion.zeroMarket.product.ProductRepository;
import com.likelion.zeroMarket.store.Store;
import com.likelion.zeroMarket.store.StoreRepository;
import com.likelion.zeroMarket.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor  //final붙은놈 자동 주입
@RequestMapping("/")
public class MainController {
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;
    private final MainService mainService;

    @GetMapping("/{address}/{category}")  //메인화면에서 지정한 지역과 카테고리에 맞는 물건들 List로 반환
    public ResponseEntity<?> mainDisplay(@PathVariable String address,
                                         @PathVariable String category){
    //와일드카드인 <?>를 붙임으로써 무슨 타입을 반환할지 지정하지 않는다.
        try{
            List<Product> productList=mainService.getProduct(address, category);
            return ResponseEntity.ok(productList);
        }catch(DataNotFoundException e) {
            return ResponseEntity.notFound().build();
            //.build로 내용 없이 ResponseEntity 객체 완성해서 return
        }
    }
}
