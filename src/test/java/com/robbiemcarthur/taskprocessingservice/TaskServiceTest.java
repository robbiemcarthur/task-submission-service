package com.robbiemcarthur.taskprocessingservice;

import com.robbiemcarthur.taskprocessingservice.service.TaskService;
import com.robbiemcarthur.taskprocessingservice.entity.Task;
import com.robbiemcarthur.taskprocessingservice.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task testTask;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testTask = createTestTask(1L, "Test Task", "PENDING");
    }

    @Test
    void givenValidTask_whenCreateTask_thenTaskIsSavedWithPendingStatus() {
        // GIVEN
        when(taskRepository.save(any(Task.class))).thenReturn(testTask);

        // WHEN
        Task result = taskService.createTask(new Task());

        // THEN
        assertNotNull(result);
        assertEquals("PENDING", result.getStatus());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void givenExistingTaskId_whenGetTaskById_thenReturnTask() {
        // GIVEN
        when(taskRepository.findById(1L)).thenReturn(Optional.of(testTask));

        // WHEN
        Task result = taskService.getTaskById(1L);

        // THEN
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(taskRepository).findById(1L);
    }

    @Test
    void givenNonExistingTaskId_whenGetTaskById_thenThrowException() {
        // GIVEN
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> taskService.getTaskById(1L));
        assertEquals("Task not found", exception.getMessage());
        verify(taskRepository).findById(1L);
    }

    @Test
    void givenTasksExist_whenGetAllTasks_thenReturnAllTasks() {
        // GIVEN
        List<Task> tasks = List.of(
                createTestTask(1L, "Task 1", "PENDING"),
                createTestTask(2L, "Task 2", "COMPLETED")
        );
        when(taskRepository.findAll()).thenReturn(tasks);

        // WHEN
        List<Task> result = taskService.getAllTasks();

        // THEN
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getName());
        verify(taskRepository, times(1)).findAll();
    }

    // Helper method to create a test task
    private Task createTestTask(Long id, String name, String status) {
        Task task = new Task();
        task.setId(id);
        task.setName(name);
        task.setStatus(status);
        return task;
    }
}
