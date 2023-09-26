package com.clean.architecture.sharedexpenses.common.exception;

public class PaginationException extends BusinessValidationException {

  public static final String MIN_PAGE_ERROR = "pagination.page.min";
  public static final String MIN_SIZE_ERROR = "pagination.size.min";
  public static final String MAX_SIZE_ERROR = "pagination.size.max";

  public PaginationException(String message) {
    super(message);
  }
}
