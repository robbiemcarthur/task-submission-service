package com.robbiemcarthur.taskprocessingservice.taskmanagement.repository;

import com.robbiemcarthur.taskprocessingservice.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
