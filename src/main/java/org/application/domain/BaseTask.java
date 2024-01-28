package org.application.domain;

import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

// TODO: ver boas práticas de valor padrão para updatedAt no Java

public class BaseTask {
    private String id;
    private String taskTitle;
    private String taskDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private TaskStatus taskStatus;
    private Date dueDate;
    private TaskPriority taskPriority;

    public BaseTask(String id, String taskTitle, String taskDescription, LocalDateTime createdAt, LocalDateTime updatedAt, TaskStatus taskStatus, Date dueDate, TaskPriority taskPriority) {
        this.id = UUID.randomUUID().toString();
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
        this.taskStatus = taskStatus;
        this.dueDate = dueDate;
        this.taskPriority = taskPriority;
    }

    public String getId() {
        return id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public String toString() {
        return (
                "\n ***** TASK ***** \n" +
                "Task title: " + taskTitle + "\n" +
                "Description: " + taskDescription + "\n" +
                "Created at: " + createdAt + "\n" +
                "Update at: " + updatedAt + "\n" +
                "Status: " + taskStatus + "\n" +
                "Due date: " + dueDate + "\n" +
                "UUID: " + id + "\n" +
                "****************"
                );
    }

}