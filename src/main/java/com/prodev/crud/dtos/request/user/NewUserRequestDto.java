package com.prodev.crud.dtos.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserRequestDto {
  private String name;
  private String email;
  private String password;
}
