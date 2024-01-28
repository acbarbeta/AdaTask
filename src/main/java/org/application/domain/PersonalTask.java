package org.application.domain;

import org.application.domain.enums.PersonalTaskCategory;
import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class PersonalTask extends BaseTask {
    private PersonalTaskCategory category;

    public PersonalTask(String id, String taskTitle, String taskDescription, LocalDateTime createdAt, LocalDateTime updatedAt, TaskStatus taskStatus, Date dueDate, TaskPriority taskPriority, PersonalTaskCategory category) {
        super(id, taskTitle, taskDescription, createdAt, updatedAt, taskStatus, dueDate, taskPriority);
        this.category = category;
    }

    public PersonalTaskCategory getCategory() {
        return category;
    }

    public void setCategory(PersonalTaskCategory category) {
        this.category = category;
    }
}
