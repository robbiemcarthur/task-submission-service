package com.robbiemcarthur.taskprocessingservice.taskmanagement.event;

import com.robbiemcarthur.taskprocessingservice.taskmanagement.entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class TaskEventListenerTest {

    @Test
    void shouldHandleTaskCreatedEvent() {
        TaskEventListener listener = new TaskEventListener();
        Task task = new Task("Sample Task");
        TaskCreatedEvent event = new TaskCreatedEvent(task);

        listener.handleTaskCreated(event);

        assertThat(event.task().getDescription()).isEqualTo("Sample Task");
    }
}