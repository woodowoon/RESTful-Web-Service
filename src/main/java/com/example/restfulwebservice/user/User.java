package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data // lombok를 통해 생성자를 생성해주지 않아도 괜찮다.
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
}
