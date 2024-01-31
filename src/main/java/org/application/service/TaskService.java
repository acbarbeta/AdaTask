package org.application.service;

import org.application.domain.BaseTask;
import org.application.repository.TaskRepository;

import java.util.List;

public class TaskService<T extends BaseTask, U> {

    private final TaskRepository<T, U> taskRepository = new TaskRepository<>();

    public void createTask(T task) {
        taskRepository.createTask(task);
    }

    public void deleteTask(T task) {
        taskRepository.deleteTask(task);
    }

    public void updateTask(T task) {
        taskRepository.updateTask(task);
    }

    public List<T> findAll() {
        List<T> tasks = taskRepository.findAll();
        for (T task : tasks) {
            task.printTask();
        }
        return tasks;
    }

    public T findById(String id) {
        return (T) taskRepository.findById(id);
    }

}
