package com.company.service;

import com.company.entity.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

    boolean isEmailExists(String email);

    void save(User user);

    void delete(Long id);

    List<User> list();

    User getById(Long id);

    void updateBannedFlag(String email, boolean isBanned);

    List<String> listOfBannedUserEmail();

}