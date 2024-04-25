package com.prodev.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prodev.crud.dtos.request.tasks.TaskRequestDto;
import com.prodev.crud.dtos.response.general.SuccessResponseDto;
import com.prodev.crud.dtos.response.tasks.SimpleTaskResponse;
import com.prodev.crud.entities.TaskEntity;
import com.prodev.crud.exceptions.EntityNotFoundException;
import com.prodev.crud.mappers.TaskMapper;
import com.prodev.crud.repositories.TaskRepository;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private TaskMapper taskMapper;

  public ResponseEntity<List<SimpleTaskResponse>> getTasks() {
    List<TaskEntity> tasks = taskRepository.findAll();
    List<SimpleTaskResponse> mappedTasks = taskMapper.entityListToListDto(tasks);

    return ResponseEntity.ok(mappedTasks);
  }

  public ResponseEntity<SimpleTaskResponse> createTask(TaskRequestDto taskRequestDto) {
    TaskEntity newTask = new TaskEntity();

    newTask.setTaskName(taskRequestDto.getTaskName());
    newTask.setTaskDescription(taskRequestDto.getTaskDescription());
    newTask.setIsComplete(false);

    TaskEntity savedEntity = taskRepository.save(newTask);

    return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.taskEntityToDto(savedEntity));
  }

  public ResponseEntity<?> updateTask(Long taskId, TaskRequestDto taskDto) {
    TaskEntity task = taskRepository.findById(taskId).orElse(null);

    if (task == null) {
      throw new EntityNotFoundException("Tarea con ID " + taskId + " no fue encontrada");
    }

    task.setTaskName(taskDto.getTaskName());
    task.setTaskDescription(taskDto.getTaskDescription());

    taskRepository.save(task);

    SuccessResponseDto response = new SuccessResponseDto();

    response.setStatus(200);
    response.setMessage("Tarea actualizada correctamente");

    return ResponseEntity.ok(response);
  }

  public ResponseEntity<?> setTaskStatus(Long taskId, Boolean isComplete) {
    TaskEntity task = taskRepository.findById(taskId).orElse(null);

    if (task == null) {
      throw new EntityNotFoundException("Tarea con ID " + taskId + " no fue encontrada");
    }

    task.setIsComplete(isComplete);

    taskRepository.save(task);

    SuccessResponseDto response = new SuccessResponseDto();

    response.setStatus(200);
    response.setMessage("Estado de la tarea actualizado correctamente");

    return ResponseEntity.ok(response);
  }

  public ResponseEntity<?> deleteTask(Long taskId) {
    TaskEntity task = taskRepository.findById(taskId).orElse(null);

    if (task == null) {
      throw new EntityNotFoundException("Tarea con ID " + taskId + " no fue encontrada");
    }

    taskRepository.delete(task);

    SuccessResponseDto response = new SuccessResponseDto();

    response.setStatus(200);
    response.setMessage("Tarea eliminada correctamente");

    return ResponseEntity.ok(response);
  }
}
