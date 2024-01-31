package org.application.repository;

import org.application.domain.BaseTask;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository<T extends BaseTask, S> implements Repository<T, S>{
    private List<T> tasks;

    public TaskRepository() {
        tasks = new ArrayList<>();
    }

    @Override
    public void createTask(T task) {
        tasks.add(task);
    }

    @Override
    public void updateTask(T task) {
        int arrayIndex = findIndexById(task.getId());
        task.setUpdatedAt(LocalDateTime.now());
        tasks.set(arrayIndex, task); // .set() allows you to modify an element
    }

    @Override
    public void deleteTask(T task) {
        int arrayIndex = findIndexById(task.getId());
        if(arrayIndex == -1) {
            System.out.println("Not found.");
        } else {
            tasks.remove(task);
            System.out.println("Task deleted.");
        }
    }

    @Override
    public List<T> findAll() {
        return tasks;
    }

    @Override
    public T findById(String id) {
        Integer arrayIndex = findIndexById(id);
        if (arrayIndex == -1) {
            throw new IllegalArgumentException("There is no task with required UUID");
        }
        return tasks.get(arrayIndex);
    }

    private int findIndexById(String id) {
        int index = -1;
        for(int i=0; i < tasks.size();i++){
            if(tasks.get(i).equals(id)){
                return i;
            }
        }
        return index;
    }

}
