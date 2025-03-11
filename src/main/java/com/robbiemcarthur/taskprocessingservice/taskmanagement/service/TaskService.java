package com.robbiemcarthur.taskprocessingservice.taskmanagement.service;

import com.robbiemcarthur.taskprocessingservice.taskmanagement.entity.Task;
import com.robbiemcarthur.taskprocessingservice.taskmanagement.event.TaskCreatedEvent;
import com.robbiemcarthur.taskprocessingservice.taskmanagement.model.response.TaskResponse;
import com.robbiemcarthur.taskprocessingservice.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ApplicationEventPublisher eventPublisher;

    public TaskService(TaskRepository taskRepository, ApplicationEventPublisher eventPublisher) {
        this.taskRepository = taskRepository;
        this.eventPublisher = eventPublisher;
    }

    public TaskResponse createTask(String description) {
        Task task = taskRepository.save(new Task(description));
        eventPublisher.publishEvent(new TaskCreatedEvent(task));
        return new TaskResponse(task.getDescription());
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream().map(entity -> new TaskResponse(entity.getDescription())).toList();
    }
}

