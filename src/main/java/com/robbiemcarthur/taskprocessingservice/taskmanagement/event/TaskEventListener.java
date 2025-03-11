package com.robbiemcarthur.taskprocessingservice.taskmanagement.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskEventListener {

    @EventListener
    public void handleTaskCreated(final TaskCreatedEvent event) {
        System.out.println("Task Created: " + event.task().getDescription());
    }
}

