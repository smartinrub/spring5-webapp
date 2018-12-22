package org.smartinrubio.spring5webapp.repository;

import org.smartinrubio.spring5webapp.exception.DuplicateUserException;
import org.smartinrubio.spring5webapp.exception.UserNotFoundException;
import org.smartinrubio.spring5webapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    public User save(User user) {
        Optional<User> existingUser = users.stream().filter(userToFind -> userToFind.getFirstName().equals(user.getFirstName())).findAny();

        if (existingUser.isPresent()) {
            throw new DuplicateUserException();
        }

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
