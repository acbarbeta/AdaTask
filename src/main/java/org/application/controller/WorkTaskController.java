package org.application.controller;

import org.application.domain.BaseTask;
import org.application.domain.StudyTask;
import org.application.domain.WorkTask;
import org.application.domain.enums.TaskPriority;
import org.application.service.TaskService;

import java.time.LocalDate;
import java.util.Scanner;

public class WorkTaskController<T extends BaseTask> {

    private TaskService<T, WorkTask> service = new TaskService<>();

    public void workTaskMenu() {
        boolean run = true;
        while(run) {
            Scanner input = new Scanner(System.in);

            System.out.println("***** WORK TASKS *****");
            System.out.println("Select the option to choose an action or type 0 to go back to main menu: \n");

            System.out.println("1. Create task");
            System.out.println("2. See all tasks in category");
            System.out.println("3. Edit task");
            System.out.println("4. Delete task");

            int option = input.nextInt();
            chooseOption(option);
        }
    }

    public void chooseOption(int option) {
        Scanner input = new Scanner(System.in);
        boolean run;


        switch (option){
            case 1:
                System.out.println("Type the task title: \n");
                String taskTitle = input.nextLine();
                System.out.println("Type the task description: \n");
                String taskDescription = input.nextLine();
                System.out.println("To set the due date, please type the following infos: \n");
                System.out.println("Year of due date: YYYY");
                int year = input.nextInt();
                System.out.println("Month of due date: MM");
                int month = input.nextInt();
                System.out.println("Day of due date: DD");
                int day = input.nextInt();
                LocalDate dueDate = LocalDate.of(year, month, day);
                System.out.println("Please, choose task priority: ");
                TaskPriority priority = selectTaskPriority();
                BaseTask task = new BaseTask(taskTitle, taskDescription, dueDate, priority);
                service.createTask((T) task);
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

    public void createWorkTask(){
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

        System.out.println("Type the task project: ");
        String project = input.nextLine();

        System.out.println("Type the task project: ");
        String client = input.nextLine();

        System.out.println("Please, choose task priority: ");
        TaskPriority priority = selectTaskPriority();
        WorkTask task = new WorkTask(taskTitle, taskDescription, dueDate, priority, project, client);
        service.createTask((T) task);
        System.out.println("***** Personal task created successfully! *****");
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
}
