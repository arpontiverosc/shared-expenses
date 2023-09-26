package com.clean.architecture.sharedexpenses.common.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class FieldValidationException extends RuntimeException {

  private final List<String> messages;

  public FieldValidationException(List<String> messages) {
    this.messages = messages;
  }
}
