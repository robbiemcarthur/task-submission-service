package com.robbiemcarthur.taskprocessingservice.service;

import com.robbiemcarthur.taskprocessingservice.entity.Task;
import com.robbiemcarthur.taskprocessingservice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setStatus("PENDING");
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
