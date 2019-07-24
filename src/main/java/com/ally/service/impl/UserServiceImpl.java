package com.ally.service.impl;

import com.ally.exception.RecordNotFoundException;
import com.ally.model.user.User;
import com.ally.repository.user.UserRepository;
import com.ally.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class UserServiceImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  UserRepository userRepository;

  @Override
  public ResponseEntity<User> addUser(User user) {
    StopWatch stopWatch = new StopWatch("Add User");
    stopWatch.start("Saving User " + user.getName());
    User savedItem = userRepository.save(user);
    stopWatch.stop();
    logger.info("\nSaved User: {}: \n{}", user.getName(), stopWatch.prettyPrint());

    return new ResponseEntity<>(savedItem, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> deleteUser(long id) throws RecordNotFoundException {
    return null;
  }

  @Override
  public ResponseEntity<User> getUser(long id) throws RecordNotFoundException {
    return null;
  }
}
