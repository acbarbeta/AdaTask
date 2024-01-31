package org.application.controller;

import org.application.domain.BaseTask;
import org.application.domain.PersonalTask;
import org.application.domain.enums.PersonalTaskCategory;
import org.application.domain.enums.TaskPriority;
import org.application.service.TaskService;

import java.awt.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class PersonalTaskController<T extends BaseTask> {
    private TaskService<T, PersonalTask> service = new TaskService<>();

    public void personalTaskMenu() {
        boolean run = true;
        while(run) {
            Scanner input = new Scanner(System.in);

            System.out.println("***** PERSONAL TASKS *****");
            System.out.println("Select the option to choose an action or type 0 exit: \n");
            System.out.println("1. Create task");
            System.out.println("2. See all tasks in category");
            System.out.println("3. Edit task");
            System.out.println("4. Delete task");

            int option = input.nextInt();
            chooseOption(option);
        }
    }

    public void chooseOption(int option) {
        boolean run;


        switch (option){
            case 1:
                createPersonalTask();
                break;
            case 2:
                service.findAll();
                break;
            case 3:

                System.out.println("Digite o UUID da task que deseja editar: ");

                break;
            case 4:
                break;
            case 0:
                run = false;
            default:
                System.out.println("Invalid Option. Please, try again.");
        }
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

    public void createPersonalTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("***** Create new personal task *****");

        System.out.println("Type the task title:");
        String taskTitle = input.nextLine();

        System.out.println("Type the task description:");
        String taskDescription = input.nextLine();

        System.out.println("To set the due date, please type the following infos:");
        System.out.println("Year of due date: YYYY");
        int year = input.nextInt();
        System.out.println("Month of due date: MM");
        int month = input.nextInt();
        System.out.println("Day of due date: DD");
        int day = input.nextInt();
        input.nextLine();
        LocalDate dueDate = LocalDate.of(year, month, day);

        PersonalTaskCategory category = choosePersonalTaskCategory();

        System.out.println("Please, choose task priority: ");
        TaskPriority priority = selectTaskPriority();
        PersonalTask task = new PersonalTask(taskTitle, taskDescription, dueDate, priority, category);
        service.createTask((T) task);
        System.out.println("***** Personal task created successfully! *****");
    }

    public void editPersonalTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("***** Edit existing personal task *****");

        System.out.println("Type the UUID of the task you want to edit: ");
        String taskId = input.nextLine();
        service.findById(taskId);


    }

    public PersonalTaskCategory choosePersonalTaskCategory() {
        Scanner input = new Scanner(System.in);

        System.out.println("Type the number of the category: ");
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
