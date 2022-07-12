package com.dim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ApiController {
    private final TaskStorage taskStorage;

    @Autowired
    public ApiController(TaskStorage taskStorage) {
        this.taskStorage = taskStorage;
    }

    @GetMapping("/tasks")
    public List<Task> listTasks() {
        return taskStorage.getTasks();
    }


    @PostMapping("/tasks")
    public ApiResponse addTask(@RequestParam String text) {
        taskStorage.addTask(text);
        return ApiResponse.ok();
    }

    @DeleteMapping("/tasks")
    public ApiResponse deleteTask(@RequestParam int id) {
        return taskStorage.deleteTask(id) ? ApiResponse.ok() : ApiResponse.error("Task not found");
    }

    @PostMapping("/tasks/complete")
    public ApiResponse setComplete(@RequestParam int id, @RequestParam boolean value) {
        return taskStorage.setComplete(id, value) ? ApiResponse.ok() : ApiResponse.error("Task not found");
    }
}
