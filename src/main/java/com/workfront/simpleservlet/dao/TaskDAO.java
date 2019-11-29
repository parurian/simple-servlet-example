package com.workfront.simpleservlet.dao;

import com.workfront.simpleservlet.entity.Task;

import java.util.List;

/**
 * User: MheR
 * Date: 11/29/19.
 * Time: 12:46 AM.
 * Project: simpleservlet.
 * Package: com.workfront.simpleservlet.dao.impl.
 */
public interface TaskDAO {

    List<Task> findAll();

    Task findOne(Long taskId);

    boolean update(Task task);

    void create(Task task);

    boolean delete(Long taskId);


}
