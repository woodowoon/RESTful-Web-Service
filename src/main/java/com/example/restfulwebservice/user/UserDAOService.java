package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service // 어노테이션 지정
public class UserDAOService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "dowoon", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(3, "dElena", new Date()));
    }

    public List<User> findAll() { // 전체 사용자 조회
        return users;
    }

    public User save(User user) { // 등록
        if(user.getId() == null) { // ID의 값이 존재하지 않으면 ID 값을 넣어준다.
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) { // 개별 사용자 조회
        for (User user : users) {
            if ( user.getId() == id ) {
                return user;
            }
        }
        return null;
    }
}
