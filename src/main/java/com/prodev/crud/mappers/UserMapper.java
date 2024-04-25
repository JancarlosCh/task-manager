package com.prodev.crud.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.prodev.crud.dtos.request.user.NewUserRequestDto;
import com.prodev.crud.dtos.response.user.SimpleUserResponseDto;
import com.prodev.crud.entities.UserEntity;

@Component
public class UserMapper {

  public SimpleUserResponseDto entityToDto(UserEntity entity) {
    SimpleUserResponseDto dto = new SimpleUserResponseDto();
    dto.setId(entity.getUserId());
    dto.setName(entity.getName());
    dto.setEmail(entity.getEmail());
    return dto;
  }

  public UserEntity dtoToEntity(NewUserRequestDto dto) {
    UserEntity entity = new UserEntity();
    entity.setName(dto.getName());
    entity.setEmail(dto.getEmail());
    entity.setPassword(dto.getPassword());
    return entity;
  }

  public List<SimpleUserResponseDto> entityListToDto(List<UserEntity> entities) {
    return entities
    .stream()
    .map(this::entityToDto)
    .collect(Collectors.toList());
  }

}
