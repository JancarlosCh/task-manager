package com.prodev.crud.controllers;

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

import com.prodev.crud.dtos.request.tasks.TaskRequestDto;
import com.prodev.crud.dtos.request.tasks.TaskStatusDto;
import com.prodev.crud.services.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<?> getTask() {
        return taskService.getTasks();
    }

    @PostMapping("/task")
    public ResponseEntity<?> createTask(@RequestBody TaskRequestDto requestDto) {
        return taskService.createTask(requestDto);
    }

    @PutMapping("/task/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable Long taskId, @RequestBody TaskRequestDto requestDto) {
        return taskService.updateTask(taskId, requestDto);
    }

    @PutMapping("/task/{taskId}/setStatus")
    public ResponseEntity<?> setTaskStatus(@PathVariable Long taskId, @RequestBody TaskStatusDto taskStatusDto) {
        return taskService.setTaskStatus(taskId, taskStatusDto.getIsComplete());
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        return taskService.deleteTask(taskId);
    }
}
