package com.epam.spring.web.mvc.rentcarservice.persistence.dao;

import com.epam.spring.web.mvc.rentcarservice.persistence.model.User;

public interface UserRepository {
    User getUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);
}
