package com.likelion.zeroMarket.store;


import com.likelion.zeroMarket.dto.StoreCreateRequestDto;
import com.likelion.zeroMarket.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {  
    @OneToOne(mappedBy = "store")  
    //JPA에서는 일대일 대응은 무조건 양방향이여야 됨 즉, 양쪽 엔티티에서 OneToOne 해줘야됨
    private User user;

    // 자꾸 오류뜸 ㅠㅠ
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동으로 증가하도록 설정
    @Column
    private Long id;

    @Column
    private String picture;

    @Column
    private String name;

    @Column
    private String explanation;


    @Column
    private Double latitude;  //위도

    @Column
    private Double longitude;  //경도
    
    @Column
    private String address;  //~~동

    @Column
    private String feature;
    public static Store from(StoreCreateRequestDto store) {
        return Store.builder()
                .picture(store.getPicture())
                .name(store.getName())
                .explanation(store.getExplanation())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .feature(store.getFeature())
                .build();
    }
}


