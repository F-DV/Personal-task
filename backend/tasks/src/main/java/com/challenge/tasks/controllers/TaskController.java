package com.challenge.tasks.controllers;

import com.challenge.tasks.dto.TaskDto;
import com.challenge.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/tasks")
    public List<TaskDto>  getTasks(){
        return this.taskService.getTasks();
    }

    @PostMapping(path = "/saveTask")
    public TaskDto createNewTask(@RequestBody TaskDto taskDto){

        return this.taskService.createTask(taskDto);
    }

    @PutMapping(path = "/{id}")
    public TaskDto updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto){

        TaskDto taskDto1 = taskService.findById(id);
        taskDto1.setType(taskDto.getType());
        taskDto1.setPriority(taskDto.getPriority());
        taskDto1.setDescription(taskDto.getDescription());

        this.taskService.saveTask(taskDto1);
        return this.taskService.updateTask(taskDto);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.taskService.deleteTask(id);
        if(ok){
            return "La tarea fue eliminada correctamente";
        }else{
            return "No se elimino la tarea";
        }
    }
}
