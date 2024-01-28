package org.application.repository;

import org.application.domain.BaseTask;

import java.util.List;

public class GeneralRepository<T extends BaseTask, S> implements Repository<T, S>{
    private List<T> tasks;

}
