package com.likelion.zeroMarket.product;

import com.likelion.zeroMarket.dto.ProductCreateRequestDto;
import com.likelion.zeroMarket.store.Store;
import com.likelion.zeroMarket.store.StoreRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne(targetEntity = Store.class, fetch = FetchType.LAZY)
    //FetchType.LAZY는 지연로딩. 즉시로딩인 EAGER는 예상치 못한 쿼리문 나갈수 있음
    @JoinColumn(name="store_id")
    private Store store;

    @Column
    private String category;

    @Column
    private String name;

    @Column
    private int stockQuantity;

    //TODO: endTime지나면 상품 DB에서 자동삭제
    //static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)
    @Column
    private LocalDateTime endTime;

    @Column
    private int culPrice;

    @Column
    private int salePrice;

    @Column
    private String picture;

    //TODO:등록날짜, 수정날짜
    @Column
    @CreatedDate
    private LocalDateTime createDate;

    @Column
    @LastModifiedDate
    private LocalDateTime updateDate;  //굳이 수정날짜까지 둘필요 있나??

    public static Product from(ProductCreateRequestDto productDto){
        return Product.builder()
                .category(productDto.getCategory())
                .name(productDto.getName())
                .stockQuantity(productDto.getStockQuantity())
                .endTime(productDto.getEndTime())
                .culPrice(productDto.getCulPrice())
                .salePrice(productDto.getSalePrice())
                .picture(productDto.getPicture())
                .build();
    }

}
