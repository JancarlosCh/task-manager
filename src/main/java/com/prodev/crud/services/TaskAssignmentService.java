package com.prodev.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prodev.crud.dtos.request.tasks.TaskAssignmentDto;
import com.prodev.crud.dtos.response.tasks.SimpleTaskResponse;
import com.prodev.crud.dtos.response.user.UserTasksDto;
import com.prodev.crud.entities.TaskEntity;
import com.prodev.crud.entities.UserEntity;
import com.prodev.crud.exceptions.EntityNotFoundException;
import com.prodev.crud.mappers.TaskMapper;
import com.prodev.crud.repositories.TaskRepository;
import com.prodev.crud.repositories.UserRepository;

@Service
public class TaskAssignmentService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private TaskMapper taskMapper;

  public ResponseEntity<?> assignTask(Long userId, TaskAssignmentDto userTaskDto) {
    Optional<UserEntity> userOptional = userRepository.findById(userId);
    Optional<TaskEntity> taskOptional = taskRepository.findById(userTaskDto.getTaskId());

    if (!userOptional.isPresent() && !taskOptional.isPresent()) {
      throw new EntityNotFoundException("Usuario o tarea no encontrados");
    }

    UserEntity user = userOptional.get();
    TaskEntity task = taskOptional.get();

    task.setUser(user);
    taskRepository.save(task);

    return ResponseEntity.ok(taskMapper.taskEntityToCompleteDto(task, user));
  }

  public ResponseEntity<?> getTaskByUserId(Long userId) {
    Optional<UserEntity> userOptional = this.userRepository.findById(userId);

    if (!userOptional.isPresent()) {
      throw new EntityNotFoundException("Usuario con ID " + userId + " no fue encontrado");
    }

    UserEntity userFound = userOptional.get();

    UserTasksDto response = new UserTasksDto();

    response.setUser(userFound.getName());

    List<SimpleTaskResponse> task = taskMapper.entityListToListDto(userFound.getUserTasks());
    response.setTasks(task);

    return ResponseEntity.ok(response);
  }
}
