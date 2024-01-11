package com.likelion.zeroMarket.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //User객체를 저장하는 리포지토리인데, PK가 String타입

    Optional<User> findByIdAndAccount(String id, String account);
    //Optional 형태로 받아야 서비스에서 OrElseThrow 사용 가능
}
