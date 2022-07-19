package com.challenge.tasks.mappers;

import com.challenge.tasks.dao.TaskDao;
import com.challenge.tasks.dto.TaskDto;
import com.challenge.tasks.entities.Task;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TaskMapper {

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "priority", source = "priority"),
    })
    TaskDto taskToTaskDto(Task task);

    @InheritInverseConfiguration
    Task taskDtoToTask(TaskDto taskDto);

}
