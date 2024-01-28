package org.application.domain;

import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class WorkTask extends BaseTask {
    private String project;
    private String client;

    public WorkTask(String id, String taskTitle, String taskDescription, LocalDateTime createdAt, LocalDateTime updatedAt, TaskStatus taskStatus, Date dueDate, TaskPriority taskPriority, String project, String client) {
        super(id, taskTitle, taskDescription, createdAt, updatedAt, taskStatus, dueDate, taskPriority);
        this.project = project;
        this.client = client;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
