package com.prodev.crud.dtos.response.user;

import java.util.Collection;

import com.prodev.crud.dtos.response.tasks.SimpleTaskResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTasksDto {
    private String user;
    private Collection<SimpleTaskResponse> tasks;
}
