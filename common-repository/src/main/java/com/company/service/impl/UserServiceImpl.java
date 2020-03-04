package com.company.service.impl;

import com.company.entity.User;
import com.company.exception.UserNotFoundException;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findByEmail(String email){
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(String.format("Could not find user by email %s.", email)));
    }

    @Override
    public boolean isEmailExists(String email) {
        return repository.existsUserByEmail(email);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> list() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException(String.format("Could not find user by id  %s.", id.toString())));
    }

    @Transactional
    @Override
    public void updateBannedFlag(String email, boolean isBanned) {
         repository.updateUserBanned(email,isBanned);
    }

    @Override
    public List<String> listOfBannedUserEmail() {
        return repository.listOfBannedUserEmail();
    }
}
