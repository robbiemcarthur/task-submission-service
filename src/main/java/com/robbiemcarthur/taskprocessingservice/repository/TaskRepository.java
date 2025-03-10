package com.robbiemcarthur.taskprocessingservice.repository;

import com.robbiemcarthur.taskprocessingservice.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
