package com.prodev.crud.dtos.request.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class TaskStatusDto {
  @JsonProperty("is_complete")
  private Boolean isComplete;
}
