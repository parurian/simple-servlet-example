package com.workfront.simpleservlet.entity;

/**
 * User: MheR
 * Date: 11/29/19.
 * Time: 12:43 AM.
 * Project: simpleservlet.
 * Package: com.workfront.simpleservlet.entity.
 */
public class Task {


    private Long taskId;
    private String name;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task(String name) {
        this.setName(name);
        this.setTaskId(System.currentTimeMillis());
    }

    public Task() {
        this.setTaskId(System.currentTimeMillis());
    }

}
