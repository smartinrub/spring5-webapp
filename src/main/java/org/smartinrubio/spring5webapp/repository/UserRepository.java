package org.smartinrubio.spring5webapp.repository;

import org.smartinrubio.spring5webapp.exception.UserNotFoundException;
import org.smartinrubio.spring5webapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findByName(String name) {
        return users.stream()
                .filter(user -> user.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }
}
