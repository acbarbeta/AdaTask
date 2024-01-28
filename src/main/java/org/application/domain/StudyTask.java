package org.application.domain;

import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class StudyTask extends BaseTask {
    private String subject;

    public StudyTask(String id, String taskTitle, String taskDescription, LocalDateTime createdAt, LocalDateTime updatedAt, TaskStatus taskStatus, Date dueDate, TaskPriority taskPriority, String subject) {
        super(id, taskTitle, taskDescription, createdAt, updatedAt, taskStatus, dueDate, taskPriority);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString() {
        return (
                "\n ***** PERSONAL TASK ***** \n" +
                        "Task title: " + super.getTaskTitle() + "\n" +
                        "Description: " + super.getTaskDescription() + "\n" +
                        "Created at: " + super.getCreatedAt() + "\n" +
                        "Update at: " + super.getUpdatedAt() + "\n" +
                        "Status: " + super.getTaskStatus() + "\n" +
                        "Due date: " + super.getDueDate() + "\n" +
                        "Subject: " + subject + "\n" +
                        "UUID: " + super.getId() + "\n" +
                        "*************************"
        );
    }
}
