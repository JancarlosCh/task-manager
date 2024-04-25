package com.prodev.crud.dtos.response.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleTaskResponse {
  @JsonProperty("task_id")
  Long taskId;

  @JsonProperty("task_name")
  private String taskName;

  @JsonProperty("task_description")
  private String taskDescription;

  @JsonProperty("is_complete")
  private Boolean isComplete;
}
