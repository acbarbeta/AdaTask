package org.application.controller;

import org.application.domain.BaseTask;
import org.application.domain.PersonalTask;
import org.application.domain.StudyTask;
import org.application.domain.WorkTask;
import org.application.domain.enums.GeneralTaskCategory;
import org.application.service.TaskService;

import java.util.Scanner;

public class TaskController<T extends BaseTask> {

    private final TaskService<T, BaseTask> service = new TaskService<>();

    public void mainMenu() {
        boolean run = true;
        while (run) {
            Scanner input = new Scanner(System.in);

            System.out.println("***** ADA TASK *****");
            System.out.println("Welcome to Ada Task! \nPlease, type the option that corresponds to the type of task you want to manage:\n");
            System.out.println("1. Personal task");
            System.out.println("2. Study tasks");
            System.out.println("3. Work task");
            System.out.println("0. Exit");

            int option = input.nextInt();
            run = selectGeneralTaskCategory(option);
        }
    }

    public boolean selectGeneralTaskCategory(int option) {
        GeneralTaskCategory taskCategory = null;

        switch (option){
            case 1:
                taskCategory = GeneralTaskCategory.PERSONAL;
                callPersonalTaskController();
                return true;
            case 2:
                taskCategory = GeneralTaskCategory.STUDY;
                callStudyTaskController();
                return true;
            case 3:
                taskCategory = GeneralTaskCategory.WORK;
                callWorkTaskController();
                return true;
            default:
                System.out.println("\n***** Exiting application *****");
                return false;
        }
    }

    public static void callPersonalTaskController(){
        PersonalTaskController<PersonalTask> personalTaskController = new PersonalTaskController<>();
        personalTaskController.personalTaskMenu();
    }
    public static void callWorkTaskController(){
        WorkTaskController<WorkTask> workTaskController = new WorkTaskController();
        workTaskController.workTaskMenu();
    }
    public static void callStudyTaskController(){
        StudyTaskController<StudyTask> studyTaskController = new StudyTaskController();
        studyTaskController.studyTaskMenu();
    }

}


