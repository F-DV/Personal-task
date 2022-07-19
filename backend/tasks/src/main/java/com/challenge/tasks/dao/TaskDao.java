package com.challenge.tasks.dao;

import com.challenge.tasks.entities.Task;

import java.util.List;

public interface TaskDao {

    List<Task> getTasks();
    void createTask(Task task);
    void updateTask(Task task);
    Task findById(Long id);
    void saveTask(Task task);
    void deleteById(Long id);
}
