package com.challenge.tasks.mappers;

import com.challenge.tasks.dto.TaskDto;
import com.challenge.tasks.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TaskMapper {

    @Mappings({
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "priority", source = "priority"),
    })
    TaskDto taskDaoToTaskDto(Task task);

}
