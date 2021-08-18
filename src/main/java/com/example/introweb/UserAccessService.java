package com.example.introweb;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserAccessService {

    private static List<User> users = new ArrayList<>();

    private static int counter = 3;

    static {
        users.add(new User(1, "Paul", new Date()));
        users.add(new User(2, "Cable", new Date()));
        users.add(new User(3, "Joseph", new Date()));
        users.add(new User(4, "Murandiwa", new Date()));

    }

    public List<User> showAll() {
        return users;
    }

    public User add(User user) {
        if (user.getId() == null){
            user.setId(++counter);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user: users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteUser(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
