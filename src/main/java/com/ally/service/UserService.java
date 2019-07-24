package com.ally.service;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.user.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

  ResponseEntity<User> addUser(User user);

  ResponseEntity<String> deleteUser(long id) throws RecordNotFoundException;

  ResponseEntity<User> getUser(long id) throws RecordNotFoundException;

}
