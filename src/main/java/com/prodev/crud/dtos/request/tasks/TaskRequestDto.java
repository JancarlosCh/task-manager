package com.prodev.crud.dtos.request.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDto {
  @JsonProperty("task_name")
  private String taskName;

  @JsonProperty("task_description")
  private String taskDescription;
}
