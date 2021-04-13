package com.epam.spring.web.mvc.rentcarservice.repository;

import com.epam.spring.web.mvc.rentcarservice.model.User;

public interface UserRepository {
    User getUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);
}
