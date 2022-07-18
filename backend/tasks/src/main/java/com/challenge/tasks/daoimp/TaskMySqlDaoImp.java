package com.challenge.tasks.daoimp;

import com.challenge.tasks.dao.TaskDao;
import com.challenge.tasks.entities.Task;
import com.challenge.tasks.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskMySqlDaoImp implements TaskDao {

    //inyeccion de dependencia
    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        return this.taskRepository.findAll();
    }
}
