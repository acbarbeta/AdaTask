package org.application.domain;

import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class StudyTask extends BaseTask {
    private String subject;

    public StudyTask(String taskTitle, String taskDescription, LocalDate dueDate, TaskPriority taskPriority, String subject) {
        super(taskTitle, taskDescription, dueDate, taskPriority);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void printTask() {
        System.out.println(
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
