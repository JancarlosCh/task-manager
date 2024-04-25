package com.prodev.crud.dtos.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
  private String name;
  private String email;
}
