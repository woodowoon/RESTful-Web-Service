package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data // lombok를 통해 생성자를 생성해주지 않아도 괜찮다.
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min = 2) // 값 사이즈 최소 2개 이상
    private String name;
    @Past // 과거 유효성 검사
    private Date joinDate;
}
