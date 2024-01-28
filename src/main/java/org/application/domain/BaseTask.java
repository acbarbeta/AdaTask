package org.application.domain;

import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class BaseTask {
    private Integer id;
    private String taskTitle;
    private String taskDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private TaskStatus taskStatus;
    private Date dueDate;
    private TaskPriority taskPriority;
}
