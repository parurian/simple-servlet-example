package com.workfront.simpleservlet.dao.impl;

import com.workfront.simpleservlet.dao.TaskDAO;
import com.workfront.simpleservlet.entity.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * User: MheR
 * Date: 11/29/19.
 * Time: 12:44 AM.
 * Project: simpleservlet.
 * Package: com.workfront.simpleservlet.dao.
 */
public class TaskDAOImpl implements TaskDAO {


    // TODO implement database querying here

    private List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Task findOne(Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean update(Task task) {
        for (Task t : tasks) {
            if (t.getTaskId() == task.getTaskId()) {
                t.setName(task.getName());
                return true;
            }
        }
        return false;
    }

    @Override
    public void create(Task task) {
        tasks.add(task);
    }


    @Override
    public boolean delete(Long taskId) {
        return tasks.removeIf(task -> task.getTaskId() == taskId);
    }
}
