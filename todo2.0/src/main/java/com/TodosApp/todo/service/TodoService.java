package com.TodosApp.todo.service;


import com.TodosApp.todo.dto.Task;
import com.TodosApp.todo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private Repository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }


    public Optional<Task> getTaskById(int id) {
        return repository.findById(id);
    }

    public void deleteTaskById(int id) {
        repository.deleteById(id);
        ;
    }


    public Task updateTask(Task task) {

        Optional<Task> task1 = repository.findById(task.getId());
        Task task2 = null;
        if (!Objects.isNull(task1)) {
            task2 = task1.get();
            if (Objects.isNull(task.getTaskMessage())) {
                task2.setStatus(task.getStatus());
            } else if (Objects.isNull(task.getStatus())) {
                task2.setTaskMessage(task.getTaskMessage());
            } else {
                task2.setStatus(task.getStatus());
                task2.setTaskMessage(task.getTaskMessage());
            }

        }
        return repository.save(task2);

    }

    }





