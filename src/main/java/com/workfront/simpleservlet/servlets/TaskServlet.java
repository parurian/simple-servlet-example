package com.workfront.simpleservlet.servlets;

import com.workfront.simpleservlet.dao.TaskDAO;
import com.workfront.simpleservlet.dao.impl.TaskDAOImpl;
import com.workfront.simpleservlet.entity.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User: MheR
 * Date: 11/28/19.
 * Time: 11:07 PM.
 * Project: simpleservlet.
 * Package: com.workfront.simpleservlet.servlets.
 */
public class TaskServlet extends HttpServlet {

    private final static TaskDAO taskDAO = new TaskDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        if ("delete".equalsIgnoreCase(type)) {
            long taskId = Long.parseLong(request.getParameter("taskId"));
            taskDAO.delete(taskId);

            // clear delete parameters by redirecting
            response.sendRedirect("/simpleservlet/tasks");
        }else {
            List<Task> tasks = taskDAO.findAll();
            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("/task/index.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        Task task = new Task();
        task.setName(name);

        taskDAO.create(task);

        response.sendRedirect("/simpleservlet/tasks");
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long taskId = Long.parseLong(request.getParameter("taskId"));

        //TODO complete later
        String name = request.getParameter("name");
        Task task = taskDAO.findOne(taskId);
        if (task == null) {
            // invalid task show error
        } else {
            task.setName(name);
            taskDAO.update(task);
        }
        response.sendRedirect("/simpleservlet/tasks");
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long taskId = Long.parseLong(request.getParameter("taskId"));
        taskDAO.delete(taskId);
        response.sendRedirect("/simpleservlet/tasks");
    }
}
