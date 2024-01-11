package com.likelion.zeroMarket.dto;


import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreCreateRequestDto {
    private String picture;
    private String name;
    private String explanation;
    private Double latitude;
    private Double longitude;
    private String feature;
    private String address;
}
