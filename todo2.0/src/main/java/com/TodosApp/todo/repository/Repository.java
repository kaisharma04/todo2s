package com.TodosApp.todo.repository;

import com.TodosApp.todo.dto.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Task, Integer> {

}
