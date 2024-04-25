package com.prodev.crud.dtos.request.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskAssignmentDto {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("task_id")
    private Long taskId;
}
