package com.ally.controller;

import com.ally.model.user.User;
import com.ally.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping
  public ResponseEntity<User> addUser(@RequestBody User user) {
    return userService.addUser(user);
  }


}
