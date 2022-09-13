package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service // 어노테이션 지정
public class UserDAOService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "dowoon", new Date(), "pass1", "701010-111111"));
        users.add(new User(2, "Alice", new Date(), "pass2", "701012-111111"));
        users.add(new User(3, "dElena", new Date(), "pass3", "701013-111111"));
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

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    public User updateUser(int id, User newUser) {  // User newUser DTO로 받는 느낌이다. 예전에 스프링으로 코드짤때의 dto랑 같다.
        for (User user : users) {
            if(user.getId() == id) {
                if(newUser.getName() == null) { // 이름을 입력하지 않으면 기존 이름 유지
                    user.setName(user.getName());
                }
                else { // 이름을 입력하면 새로운 이름으로 바꿔주기
                    user.setName(newUser.getName());
                    user.setJoinDate(new Date());
                }

                return user;
            }
        }
        return null;
    }

}
