package com.TodosApp.todo.controller;


import com.TodosApp.todo.dto.Task;
import com.TodosApp.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private TodoService todoService;

    @GetMapping("/getTasks")
    public List<Task> getTask() {
        return todoService.getAllTasks();
    }


    @PostMapping("/createTask")
    public Task createTask(@RequestBody Task task) {
        if (Objects.isNull(task.getDate())) {
            Task tasker = new Task(task);
            return todoService.createTask(tasker);
        }
        return todoService.createTask(task);
    }



    @GetMapping("/getTasks/{id}")
    public Optional<Task> getTaskById(@PathVariable int id) {
        return todoService.getTaskById(id);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTaskById(@PathVariable int id) {
        todoService.deleteTaskById(id);
    }

    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task) {
        return todoService.updateTask(task);
    }

}
