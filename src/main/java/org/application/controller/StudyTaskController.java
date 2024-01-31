package org.application.controller;

import org.application.domain.StudyTask;
import org.application.domain.enums.TaskPriority;
import org.application.domain.enums.TaskStatus;
import org.application.service.TaskService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StudyTaskController<T extends StudyTask> extends GeneralController {

    private TaskService<T, StudyTask> service = new TaskService<>();

    public void studyTaskMenu() {
        boolean run = true;
        while(run) {
            Scanner input = new Scanner(System.in);

            System.out.println("\n***** STUDY TASKS *****\n");
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

        switch (option){
            case 1:
                createStudyTask();
                return true;
            case 2:
                listAllTasks();
                return true;
            case 3:
                editStudyTask();
                return true;
            case 4:
                deleteTask();
                return true;
            case 0:
                return false;
            default:
                System.out.println("Invalid Option. Please, try again.");
                return false;
        }
    }

    public void createStudyTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("***** Create new study task *****\n");

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

        System.out.println("\nType the task subject: ");
        String subject = input.nextLine();

        System.out.println("\nPlease, choose task priority: ");
        TaskPriority priority = selectTaskPriority();

        StudyTask task = new StudyTask(taskTitle, taskDescription, dueDate, priority, subject);
        service.createTask((T) task);

        System.out.println("***** Study task created successfully! *****");
    }

    public void editStudyTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** Edit new study task *****\n");

        System.out.println("Type the UUID of the task you want to edit: ");
        String taskId = input.nextLine();
        T updatedTask = service.findById(taskId);

        System.out.println("\nType the new task title:");
        updatedTask.setTaskTitle(input.nextLine());

        System.out.println("\nType the new task description:");
        updatedTask.setTaskDescription(input.nextLine());

        System.out.println("\nTo set the due date, please type the following infos:");
        System.out.println("Year of due date: YYYY");
        int year = input.nextInt();
        System.out.println("Month of due date: MM");
        int month = input.nextInt();
        System.out.println("Day of due date: DD");
        int day = input.nextInt();
        input.nextLine();
        updatedTask.setDueDate(LocalDate.of(year, month, day));

        System.out.println("\nType the task subject: ");
        updatedTask.setSubject(input.nextLine());

        System.out.println("\nPlease, choose task priority: ");
        TaskPriority priority = selectTaskPriority();
        updatedTask.setTaskPriority(priority);


        updatedTask.setUpdatedAt(LocalDateTime.now());


        TaskStatus status = selectTaskStatus();
        updatedTask.setTaskStatus(status);

        service.updateTask(updatedTask);
        System.out.println("***** Study task updated successfully! *****");

    }

    @Override
    public void listAllTasks() {
        System.out.println("\n***** Study Tasks *****\n");
        service.findAll();
    }

    @Override
    public void deleteTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** Delete existing study task *****\n");

        System.out.println("Type the UUID of the task you want to delete: ");
        String taskId = input.nextLine();
        T taskToDelete = service.findById(taskId);
        service.deleteTask(taskToDelete);
        System.out.println("\n***** Study task deleted successfully! *****\n");
    }
}
