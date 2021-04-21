package com.epam.spring.web.mvc.rentcarservice.persistence.dao.impl;

import com.epam.spring.web.mvc.rentcarservice.exception.UserNotFoundException;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.User;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserRepositoryImpl implements UserRepository {
    private final List<User> list = new ArrayList<>();

    @Override
    public User getUser(String email) {
        log.info("Got User by email: " + email);
        return list.stream().filter(user -> user.getEmail().equals(email))
                .findFirst().orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(User user) {
        list.add(user);
        log.info("Created User " + user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = list.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            list.add(user);
        } else {
            throw new UserNotFoundException();
        }
        log.info("User with email " + email + " was updated");
        return user;
    }

    @Override
    public void deleteUser(String email) {
        list.removeIf(user -> user.getEmail().equals(email));
        log.info("User with email {} was deleted", email);
    }
}
