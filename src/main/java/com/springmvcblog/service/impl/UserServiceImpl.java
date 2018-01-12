package com.springmvcblog.service.impl;

import java.util.List;

import com.springmvcblog.ErrorHandler.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcblog.model.User;
import com.springmvcblog.repository.UserRepository;
import com.springmvcblog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        user = userRepository.save(user);
        //TODO: add blog meta info after register
        return user;

    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByName(String username){

        User user = userRepository.findByName(username);
        if(user == null)
            throw new UserNotFoundException("Page not found");
        return user;
    }

    @Override
    public boolean isNameExisted(String username){
        User user = userRepository.findByName(username);
        return user == null? false:true;
    }


    @Override
    public User findByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

}
