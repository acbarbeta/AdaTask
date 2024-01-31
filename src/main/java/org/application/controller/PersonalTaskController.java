package org.application.controller;

import org.application.domain.PersonalTask;
import org.application.domain.enums.PersonalTaskCategory;
import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;
import org.application.service.TaskService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PersonalTaskController<T extends PersonalTask>  extends GeneralController{
    private TaskService<T, PersonalTask> service = new TaskService<>();

    public void personalTaskMenu() {
        boolean run = true;
        while(run) {
            Scanner input = new Scanner(System.in);

            System.out.println("\n***** PERSONAL TASKS ***** \n");
            System.out.println("Please select an option to proceed with an action: \n");
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

        switch (option){
            case 1:
                createPersonalTask();
                return true;
            case 2:
                listAllTasks();
                return true;
            case 3:
                editPersonalTask();
                return true;
            case 4:
                deleteTask();
                return true;
            default:
                return false;
        }
    }

    public void createPersonalTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** Create new personal task ***** \n");

        System.out.println("Type the task title:");
        String taskTitle = input.nextLine();

        System.out.println("\nType the task description:");
        String taskDescription = input.nextLine();

        System.out.println("\nTo set the due date, please enter the following information:");
        System.out.println("Year of due date: YYYY");
        int year = input.nextInt();
        System.out.println("Month of due date: MM");
        int month = input.nextInt();
        System.out.println("Day of due date: DD");
        int day = input.nextInt();
        input.nextLine();
        LocalDate dueDate = LocalDate.of(year, month, day);


        PersonalTaskCategory category = choosePersonalTaskCategory();

        System.out.println("\nPlease, choose task priority: ");
        TaskPriority priority = selectTaskPriority();

        PersonalTask task = new PersonalTask(taskTitle, taskDescription, dueDate, priority, category);
        service.createTask((T) task);
        System.out.println("\n***** Your personal task has been created successfully! ***** \n");
    }

    public void editPersonalTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** Edit existing personal task *****\n");

        System.out.println("Type the UUID of the task you want to edit: ");
        String taskId = input.nextLine();
        T updatedTask = service.findById(taskId);

        System.out.println("\nType the new task title:");
        updatedTask.setTaskTitle(input.nextLine());

        System.out.println("\nType the new task description:");
        updatedTask.setTaskDescription(input.nextLine());

        System.out.println("\nTo set the new due date, please enter the following information:");
        System.out.println("Year of new due date: YYYY");
        int year = input.nextInt();
        System.out.println("Month of new due date: MM");
        int month = input.nextInt();
        System.out.println("Day of new due date: DD");
        int day = input.nextInt();
        input.nextLine();
        updatedTask.setDueDate(LocalDate.of(year, month, day));

        PersonalTaskCategory category = choosePersonalTaskCategory();
        updatedTask.setCategory(category);

        updatedTask.setUpdatedAt(LocalDateTime.now());

        System.out.println("\nPlease, choose task priority: ");
        TaskPriority priority = selectTaskPriority();
        updatedTask.setTaskPriority(priority);

        TaskStatus status = selectTaskStatus();
        updatedTask.setTaskStatus(status);


        service.updateTask(updatedTask);
        System.out.println("\n***** Your personal task has been updated successfully! *****\n");
    }

    @Override
    public void listAllTasks(){
        System.out.println("\n***** Personal Tasks *****\n");
        service.findAll();
    }

    @Override
    public void deleteTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** Delete existing personal task *****\n");

        System.out.println("Please type the UUID of the task you wish to delete:");
        String taskId = input.nextLine();
        T taskToDelete = service.findById(taskId);
        service.deleteTask(taskToDelete);
        System.out.println("\n***** Your personal task has been deleted successfully! *****\n");


    }

    public PersonalTaskCategory choosePersonalTaskCategory() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPlease type the number corresponding to the category: ");
        System.out.println("1- Health");
        System.out.println("2- Shopping");
        System.out.println("3- Leisure");
        System.out.println("4- Selfcare");

        int option = input.nextInt();
        PersonalTaskCategory category;

        switch (option){
            case 1:
                category = PersonalTaskCategory.HEALTH;
                break;
            case 2:
                category = PersonalTaskCategory.SHOPPING;
                break;
            case 3:
                category = PersonalTaskCategory.LEISURE;
                break;
            case 4:
                category = PersonalTaskCategory.SELFCARE;
                break;
            default:
                throw new IllegalArgumentException("Invalid option");
        }
        return category;
    }





}
