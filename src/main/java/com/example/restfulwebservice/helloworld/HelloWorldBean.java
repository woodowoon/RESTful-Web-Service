package com.example.restfulwebservice.helloworld;
// lombok

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // getter setter 없어도 됌
@NoArgsConstructor // 디폴트 생성자
public class HelloWorldBean {
    private String message;
}
