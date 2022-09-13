package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data // lombok를 통해 생성자를 생성해주지 않아도 괜찮다.
@AllArgsConstructor
// @JsonIgnoreProperties(value = {"password"}) // JsonIgnoreProperties 로도 데이터를 클라이언트에게 숨기는게 가능하다.
@JsonFilter("UserInfo")
public class User {
    private Integer id;

    @Size(min = 2, message = "Name은 2글자 이상 입력해주세요.") // 값 사이즈 최소 2개 이상
    private String name;
    @Past // 과거 유효성 검사
    private Date joinDate;

    // @JsonIgnore // 데이터를 클라이언트에게 숨기기
    private String password;
    // @JsonIgnore // 데이터 숨기기
    private String ssn;
}
