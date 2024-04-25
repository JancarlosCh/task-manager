package com.prodev.crud.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.prodev.crud.dtos.request.tasks.TaskRequestDto;
import com.prodev.crud.dtos.response.tasks.CompleteTaskResponseDto;
import com.prodev.crud.dtos.response.tasks.SimpleTaskResponse;
import com.prodev.crud.entities.TaskEntity;
import com.prodev.crud.entities.UserEntity;

@Component
public class TaskMapper {

    public SimpleTaskResponse taskEntityToDto(TaskEntity entity) {
        SimpleTaskResponse taskDto = new SimpleTaskResponse();

        taskDto.setTaskId(entity.getTaskId());
        taskDto.setTaskName(entity.getTaskName());
        taskDto.setTaskDescription(entity.getTaskDescription());
        taskDto.setIsComplete(entity.getIsComplete());

        return taskDto;
    }

    public CompleteTaskResponseDto taskEntityToCompleteDto(TaskEntity entity, UserEntity userEntity) {
        CompleteTaskResponseDto taskDto = new CompleteTaskResponseDto();

        taskDto.setTaskId(entity.getTaskId());
        taskDto.setTaskName(entity.getTaskName());
        taskDto.setTaskDescription(entity.getTaskDescription());
        taskDto.setIsComplete(entity.getIsComplete());
        taskDto.setIsComplete(entity.getIsComplete());
        taskDto.setUser(userEntity.getName());

        return taskDto;
    }

    public TaskEntity taskDtoToEntity(TaskRequestDto dto) {
        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setTaskName(dto.getTaskName());
        taskEntity.setTaskDescription(dto.getTaskDescription());
        taskEntity.setIsComplete(false);

        return taskEntity;
    }

    public List<SimpleTaskResponse> entityListToListDto(Collection<TaskEntity> entities) {
        return entities
        .stream()
        .map(this::taskEntityToDto)
        .collect(Collectors.toList());
    }
}
