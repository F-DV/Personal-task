package com.challenge.tasks.dao;

import com.challenge.tasks.entities.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskDao {

    List<Task> getTasks();
}
