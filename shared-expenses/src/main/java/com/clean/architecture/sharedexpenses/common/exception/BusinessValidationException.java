package com.clean.architecture.sharedexpenses.common.exception;

public class BusinessValidationException extends RuntimeException {

  protected BusinessValidationException(String message) {
    super(message);
  }

  protected BusinessValidationException(String message, Throwable cause) {
    super(message, cause);
  }
}
