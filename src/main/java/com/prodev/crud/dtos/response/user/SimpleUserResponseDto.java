package com.prodev.crud.dtos.response.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleUserResponseDto {
  private Long id;
  private String name;
  private String email;
}
