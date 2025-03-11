package com.robbiemcarthur.taskprocessingservice.taskmanagement.service;

import com.robbiemcarthur.taskprocessingservice.taskmanagement.entity.Task;
import com.robbiemcarthur.taskprocessingservice.taskmanagement.event.TaskCreatedEvent;
import com.robbiemcarthur.taskprocessingservice.taskmanagement.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock private TaskRepository taskRepository;
    @Mock private ApplicationEventPublisher eventPublisher;
    @InjectMocks private TaskService taskService;

    @Test
    void testCreateTask() {
        Task task = new Task("Test Task");
        when(taskRepository.save(any())).thenReturn(task);

        taskService.createTask("Test Task");

        verify(taskRepository, times(1)).save(any(Task.class));
        verify(eventPublisher, times(1)).publishEvent(any(TaskCreatedEvent.class));
    }
}
