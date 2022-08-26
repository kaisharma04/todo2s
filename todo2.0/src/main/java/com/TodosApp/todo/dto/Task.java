package com.TodosApp.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Task")
public class Task {

     @Id
     private int id;

     private String taskMessage;
     private Date date;
     private String status;

     public Task(Task task){
          this.id = task.id;
          this.taskMessage = task.taskMessage;
          this.date = new Date();
          this.status = task.status;
     }
}
