package com.robbiemcarthur.taskprocessingservice.taskmanagement.controller;

import com.robbiemcarthur.taskprocessingservice.taskmanagement.entity.Task;
import com.robbiemcarthur.taskprocessingservice.taskmanagement.model.response.TaskResponse;
import com.robbiemcarthur.taskprocessingservice.taskmanagement.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody String description) {
        return taskService.createTask(description);
    }
}
