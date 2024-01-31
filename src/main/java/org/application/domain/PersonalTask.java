package org.application.domain;

import org.application.domain.enums.PersonalTaskCategory;
import org.application.domain.enums.TaskPriority;

import java.time.LocalDate;

public class PersonalTask extends BaseTask {
    private PersonalTaskCategory category;

    public PersonalTask(String taskTitle, String taskDescription, LocalDate dueDate, TaskPriority taskPriority, PersonalTaskCategory category) {
        super(taskTitle, taskDescription, dueDate, taskPriority);
        this.category = category;
    }

    public PersonalTaskCategory getCategory() {
        return category;
    }

    public void setCategory(PersonalTaskCategory category) {
        this.category = category;
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
                        "Category: " + category + "\n" +
                        "UUID: " + super.getId() + "\n" +
                        "*************************"
        );
    }
}
