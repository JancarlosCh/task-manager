package com.prodev.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prodev.crud.dtos.request.user.NewUserRequestDto;
import com.prodev.crud.dtos.request.user.UpdateUserRequest;
import com.prodev.crud.dtos.response.general.ErrorResponseDto;
import com.prodev.crud.dtos.response.general.SuccessResponseDto;
import com.prodev.crud.dtos.response.user.SimpleUserResponseDto;
import com.prodev.crud.entities.UserEntity;
import com.prodev.crud.exceptions.EntityNotFoundException;
import com.prodev.crud.mappers.UserMapper;
import com.prodev.crud.repositories.UserRepository;


@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserMapper userMapper;

  public ResponseEntity<List<SimpleUserResponseDto>> getUsers() {
    List<UserEntity> users = this.userRepository.findAll();
    List<SimpleUserResponseDto> mappedUsers = this.userMapper.entityListToDto(users);
    return ResponseEntity.ok(mappedUsers);
  }

  public ResponseEntity<?> createUser(NewUserRequestDto newUserRequestDto) {

    Boolean userExists = this.userRepository.existsByEmail(newUserRequestDto.getEmail());

    if (!userExists) {
      UserEntity entityToSave = new UserEntity();

      entityToSave.setName(newUserRequestDto.getName());
      entityToSave.setEmail(newUserRequestDto.getEmail());
      entityToSave.setPassword(newUserRequestDto.getPassword());

      UserEntity savedUserEntity = this.userRepository.save(entityToSave);

      this.userMapper.entityToDto(savedUserEntity);

      SuccessResponseDto response = new SuccessResponseDto();

      response.setStatus(201);
      response.setMessage("Usuario creado correctamente");

      return ResponseEntity.ok(response);
    } else {

      ErrorResponseDto response = new ErrorResponseDto();

      response.setStatus(409);
      response.setMessage("El email ya se encuentra registrado por otro usuario");

      return ResponseEntity.ok(response);
    }
  }

  public ResponseEntity<?> updateUser(Long userId, UpdateUserRequest updateUserRequest) {
    UserEntity user = userRepository.findById(userId).orElse(null);

    if (user == null) {
      throw new EntityNotFoundException("Usuario no encontrado");
    }

    user.setName(updateUserRequest.getName());
    user.setEmail(updateUserRequest.getEmail());

    this.userRepository.save(user);

    SuccessResponseDto response = new SuccessResponseDto();

    response.setStatus(201);
    response.setMessage("Usuario actualizado correctamente");

    return ResponseEntity.ok(response);
  }

  public ResponseEntity<?> deleteUser(Long userId) {
    UserEntity user = userRepository.findById(userId).orElse(null);

    if (user == null) {
      throw new EntityNotFoundException("Usuario no encontrado");
    }

    if (!user.getUserTasks().isEmpty()) {
      ErrorResponseDto response = new ErrorResponseDto();

      response.setStatus(409);
      response.setMessage("No es posible eliminar el usuario porque tiene tareas asignadas.");

      return ResponseEntity.ok(response);
    }

    this.userRepository.deleteById(userId);

    SuccessResponseDto response = new SuccessResponseDto();

    response.setStatus(201);
    response.setMessage("Usuario eliminado correctamente");

    return ResponseEntity.ok(response);
  }
}
