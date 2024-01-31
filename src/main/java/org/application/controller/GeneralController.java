package org.application.controller;

import org.application.domain.BaseTask;
import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;
import org.application.service.TaskService;

import java.util.Scanner;

public class GeneralController<T extends BaseTask> {
    private TaskService<T, BaseTask> service = new TaskService<>();

    public TaskPriority selectTaskPriority() {
        System.out.println("\nType the number of the category priority: \n");
        System.out.println("1. LOW priority \n");
        System.out.println("2. MEDIUM priority \n");
        System.out.println("3. HIGH priority \n");
        System.out.println("4. URGENT priority \n");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        TaskPriority priority = null;

        switch (option) {
            case 1:
                priority = TaskPriority.LOW;
                break;
            case 2:
                priority = TaskPriority.MEDIUM;
                break;
            case 3:
                priority = TaskPriority.HIGH;
                break;
            case 4:
                priority = TaskPriority.URGENT;
                break;
            default:
                throw new IllegalArgumentException("Invalid option");
        }
        return priority;
    }

    public TaskStatus selectTaskStatus() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nType the number of the task status: ");
        System.out.println("1- Pending");
        System.out.println("2- In Progress");
        System.out.println("3- Done");


        int option = input.nextInt();
        TaskStatus status;

        switch (option){
            case 1:
                status = TaskStatus.PENDING;
                break;
            case 2:
                status = TaskStatus.IN_PROGRESS;
                break;
            case 3:
                status = TaskStatus.DONE;
                break;
            default:
                throw new IllegalArgumentException("Invalid option");
        }
        return status;
    }

    public void listAllTasks(){
        service.findAll();
    }

    public void deleteTask() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please type the UUID of the task you wish to delete: ");
        String taskId = input.nextLine();
        T taskToDelete = service.findById(taskId);
        service.deleteTask(taskToDelete);
    }


}
