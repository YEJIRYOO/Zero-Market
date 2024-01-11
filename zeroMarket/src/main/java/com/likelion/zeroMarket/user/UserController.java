package com.likelion.zeroMarket.user;

import com.likelion.zeroMarket.dto.StoreCreateRequestDto;
import com.likelion.zeroMarket.dto.UserSignUpRequestDto;
import com.likelion.zeroMarket.exception.DataNotFoundException;
import io.micrometer.common.lang.NonNullApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor  //final붙은놈 자동 주입
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")  //회원가입
    public ResponseEntity<?> signUp(@RequestBody UserSignUpRequestDto userDto,
                                    StoreCreateRequestDto storeDto){
        //ResponseEntity는 상태 전달 엔티티
        System.out.println("userDto의 name = " + userDto.getNickname());
        //형님 여기서 받는 2개 Dto 모두 필드들이 NULL로 넘어와..
        userService.signUp(userDto, storeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/{account}")
    public ResponseEntity<?> findPw(@PathVariable String id, @PathVariable String account){
        try{
            User user=userService.getUser(id, account);
            System.out.println("password:"+user.getPassword());
            System.out.println(user.getPassword());
            return ResponseEntity.ok(user.getPassword());
        }catch(DataNotFoundException e){
            return ResponseEntity.notFound().build();
            //.build로 내용 없이 ResponseEntity 객체 완성해서 return
        }
    }
}
