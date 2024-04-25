package com.prodev.crud.dtos.response.general;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class ErrorResponseDto {
  private Integer status;
  private String message;
}
