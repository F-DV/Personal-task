package com.challenge.tasks.controllers;

import com.challenge.tasks.dto.TaskDto;
import com.challenge.tasks.entities.Task;
import com.challenge.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/tasks")
    public List<TaskDto>  getTasks(){
        return this.taskService.getTasks();
    }
}
