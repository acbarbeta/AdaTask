package org.application.domain;

import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class BaseTask {
    private String id = UUID.randomUUID().toString();
    private String taskTitle;
    private String taskDescription;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private TaskStatus taskStatus = TaskStatus.PENDING;
    private LocalDate dueDate;
    private TaskPriority taskPriority;

    public BaseTask(String taskTitle, String taskDescription, LocalDate dueDate, TaskPriority taskPriority) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }


    public void printTask() {
        System.out.println(
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