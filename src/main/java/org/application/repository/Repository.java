package org.application.repository;

import org.application.domain.BaseTask;

import java.util.List;

public interface Repository<T extends BaseTask, S>{

    void createTask(T task);
    void updateTask(T task);
    void deleteTask(T task);
    List<T> findAll();
    T findById(String id);
}
