package com.robbiemcarthur.taskprocessingservice.taskmanagement.event;

import com.robbiemcarthur.taskprocessingservice.taskmanagement.entity.Task;

public record TaskCreatedEvent(Task task) {}
