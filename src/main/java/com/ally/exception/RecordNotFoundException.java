package com.ally.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Record not found")
public class RecordNotFoundException extends Exception {

  public RecordNotFoundException(long id, String className) {
    super(className + " not found with id: " + id);
  }

  public RecordNotFoundException(String name, String className) {
    super("Could not find " + className + " with value " + name);
  }
}
