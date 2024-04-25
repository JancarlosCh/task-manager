package com.prodev.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodev.crud.dtos.request.user.NewUserRequestDto;
import com.prodev.crud.dtos.request.user.UpdateUserRequest;
import com.prodev.crud.dtos.response.user.SimpleUserResponseDto;

import com.prodev.crud.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<SimpleUserResponseDto>> getUsers() {
    return userService.getUsers();
  }

  @PostMapping("/users")
  public ResponseEntity<?> createUser(@RequestBody NewUserRequestDto newUserRequestDto) {
    return userService.createUser(newUserRequestDto);
  }

  @PutMapping("/users/{userId}")
  public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequest updateUserRequest) {
    return userService.updateUser(userId, updateUserRequest);
  }

  @DeleteMapping("/users/{userId}")
  public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
    return userService.deleteUser(userId);
  }
}
