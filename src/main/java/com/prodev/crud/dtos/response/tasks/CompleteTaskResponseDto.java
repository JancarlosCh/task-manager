package com.prodev.crud.dtos.response.tasks;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompleteTaskResponseDto {
    private Long taskId;
    private String taskName;
    private String taskDescription;
    private Boolean isComplete;
    private String user;
}
