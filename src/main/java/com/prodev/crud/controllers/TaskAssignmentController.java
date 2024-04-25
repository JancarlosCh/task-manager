package com.prodev.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodev.crud.dtos.request.tasks.TaskAssignmentDto;
import com.prodev.crud.services.TaskAssignmentService;

@RestController
@RequestMapping("/api")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService userTaskService;

    @PostMapping("/user/{userId}/task")
    public ResponseEntity<?> assignTask(@PathVariable Long userId, @RequestBody TaskAssignmentDto taskAssignmentDto) {
        return userTaskService.assignTask(userId, taskAssignmentDto);
    }

    @GetMapping("/users/{userId}/tasks")
    public ResponseEntity<?> getTaskByUserId(@PathVariable Long userId) {
        return userTaskService.getTaskByUserId(userId);
    }

}
