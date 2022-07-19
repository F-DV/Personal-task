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
import java.util.UUID;
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
                .map(element -> mapper.taskToTaskDto(element))
                .collect(Collectors.toList());
    }

    public TaskDto createTask(TaskDto taskDto){
        Task newTask = mapper.taskDtoToTask(taskDto);
        this.taskDao.createTask(newTask);
        return mapper.taskToTaskDto(newTask);
    }

    public TaskDto saveTask(TaskDto taskDto){
        Task task = mapper.taskDtoToTask(taskDto);
        this.taskDao.saveTask(task);
        return mapper.taskToTaskDto(task);
    }

    public TaskDto updateTask(TaskDto taskDto){
        Task updatedTask = mapper.taskDtoToTask(taskDto);
        this.taskDao.updateTask(updatedTask);
        return mapper.taskToTaskDto(updatedTask);
    }

    public TaskDto findById(Long id){
        TaskDto taskDto = mapper.taskToTaskDto(this.taskDao.findById(id));
        return taskDto;
    }

    public boolean deleteTask(Long id){
        try{
            taskDao.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
