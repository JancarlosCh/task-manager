package com.prodev.crud.dtos.response.general;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponseDto {
  private Integer status;
  private String message;
}
