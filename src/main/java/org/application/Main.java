package org.application;

import org.application.controller.TaskController;
import org.application.domain.BaseTask;

public class Main {
    public static void main(String[] args) {
        TaskController controller = new TaskController();



        controller.mainMenu();
    }
}