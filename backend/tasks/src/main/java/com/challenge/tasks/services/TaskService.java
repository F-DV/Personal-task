package com.challenge.tasks.services;

import com.challenge.tasks.dao.TaskDao;
import com.challenge.tasks.dto.TaskDto;
import com.challenge.tasks.entities.Task;
import com.challenge.tasks.mappers.TaskMapper;
import com.challenge.tasks.repositories.TaskRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {


    @Autowired
    private TaskDao taskDao;


    private TaskMapper mapper = Mappers.getMapper(TaskMapper.class);

    public List<TaskDto> getTasks(){
        List<Task> tasks =
                this.taskDao.getTasks();

        return tasks
                .stream()
                .map(element -> mapper.taskDaoToTaskDto(element))
                .collect(Collectors.toList());
    }

     /*
    @Autowired
    TaskRepository taskRepository;

    public List<Task> getTasks(){
        return this.taskRepository.findAll();
    }

     */
}
