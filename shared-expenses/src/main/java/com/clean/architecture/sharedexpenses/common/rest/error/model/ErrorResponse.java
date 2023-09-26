package com.clean.architecture.sharedexpenses.common.rest.error.model;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {

  private Instant timestamp;
  private Integer status;
  private String error;
  private String detail;
  private List<String> fields;
}
