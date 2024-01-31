package org.application.controller;


import org.application.domain.WorkTask;
import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;
import org.application.service.TaskService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class WorkTaskController<T extends WorkTask> {

    private TaskService<T, WorkTask> service = new TaskService<>();

    public void workTaskMenu() {
        boolean run = true;
        while(run) {
            Scanner input = new Scanner(System.in);

            System.out.println("***** WORK TASKS *****");
            System.out.println("Select the option to choose an action: \n");
            System.out.println("1. Create task");
            System.out.println("2. See all tasks in category");
            System.out.println("3. Edit task");
            System.out.println("4. Delete task");
            System.out.println("0. Exit");

            int option = input.nextInt();
            run = chooseOption(option);
        }
    }

    public boolean chooseOption(int option) {
        Scanner input = new Scanner(System.in);
        boolean run;


        switch (option){
            case 1:
                createWorkTask();
                return true;
            case 2:
                listAllWorkTasks();
                return true;
            case 3:
                editWorkTask();
                return true;
            case 4:
                deleteWorkTask();
                return true;
            default:
                return false;
        }
    }

    public void createWorkTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** Create new work task *****\n");

        System.out.println("Type the task title:");
        String taskTitle = input.nextLine();

        System.out.println("\nType the task description:");
        String taskDescription = input.nextLine();

        System.out.println("\nTo set the due date, please type the following infos:");
        System.out.println("Year of due date: YYYY");
        int year = input.nextInt();
        System.out.println("Month of due date: MM");
        int month = input.nextInt();
        System.out.println("Day of due date: DD");
        int day = input.nextInt();
        input.nextLine();
        LocalDate dueDate = LocalDate.of(year, month, day);

        System.out.println("\nType the task project: ");
        String project = input.nextLine();

        System.out.println("\nType the task client: ");
        String client = input.nextLine();

        System.out.println("\nPlease, choose task priority: ");
        TaskPriority priority = selectTaskPriority();

        WorkTask task = new WorkTask(taskTitle, taskDescription, dueDate, priority, project, client);
        service.createTask((T) task);
        System.out.println("***** Work task created successfully! *****");
    }

    public void editWorkTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** Edit existing work task *****\n");

        System.out.println("Type the UUID of the task you want to edit: ");
        String taskId = input.nextLine();
        T updatedTask = service.findById(taskId);

        System.out.println("\nType the new task title:");
        updatedTask.setTaskTitle(input.nextLine());

        System.out.println("\nType the new task description:");
        updatedTask.setTaskDescription(input.nextLine());

        System.out.println("\nTo set the new due date, please type the following infos:");
        System.out.println("Year of new due date: YYYY");
        int year = input.nextInt();
        System.out.println("Month of new due date: MM");
        int month = input.nextInt();
        System.out.println("Day of new due date: DD");
        int day = input.nextInt();
        input.nextLine();
        updatedTask.setDueDate(LocalDate.of(year, month, day));

        System.out.println("\nType the new task project: ");
        updatedTask.setProject(input.nextLine());

        System.out.println("\nType the new task client: ");
        updatedTask.setClient(input.nextLine());


        updatedTask.setUpdatedAt(LocalDateTime.now());

        System.out.println("\nPlease, choose task priority: ");
        TaskPriority priority = selectTaskPriority();
        updatedTask.setTaskPriority(priority);

        TaskStatus status = selectTaskStatus();
        updatedTask.setTaskStatus(status);


        service.updateTask(updatedTask);
        System.out.println("\n***** Work task updated successfully! *****\n");
    }

    public void listAllWorkTasks(){
        System.out.println("\n***** Work Tasks *****\n");
        service.findAll();
    }

    public void deleteWorkTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** Delete existing work task *****\n");

        System.out.println("Type the UUID of the task you want to delete: ");
        String taskId = input.nextLine();
        T taskToDelete = service.findById(taskId);
        service.deleteTask(taskToDelete);
        System.out.println("\n***** Work task deleted successfully! *****\n");


    }

    public TaskPriority selectTaskPriority() {
        System.out.println("Type: \n");
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
}
