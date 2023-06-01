package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {


    @Autowired
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAll() {
        return userDao.findAll();
    }

    @RequestMapping(path = "/users/id/{id}", method = RequestMethod.GET)
    public User getUsersById(@PathVariable int id) {
        User user = userDao.getUserById(id);
            return user;
    }

    @RequestMapping(path = "/users/username/{username}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String username) {
        User user = userDao.findByUsername(username);
            return user;
    }

    @RequestMapping(path = "/users/id/{username}", method = RequestMethod.GET)
    public int getIdByUsername(@PathVariable String username) {
        int userId = userDao.findIdByUsername(username);
            return userId;
    }

    @GetMapping("/users/pending")
    public List<User> viewPendingApplications() {
        return userDao.viewPendingApplications();
    }
}

