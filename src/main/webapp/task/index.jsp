<%@ page import="com.workfront.simpleservlet.entity.Task" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Simple tasks servlet example</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>


<%
    ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("tasks");
%>

<div class="container">

    <div class="row">

        <div class="col-lg-5">
            <div class="p-4 bg-light mt-4 mb-4 border">
                <h4>Create task</h4>
                <form action="/simpleservlet/tasks" method="post">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <button type="submit" class="btn btn-primary">Create</button>
                </form>
            </div>

        </div>

    </div>


    <%if (tasks.size() > 0) { %>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th>#</th>
                <th>Task ID</th>
                <th>Name</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%for (int t = 0; t < tasks.size(); t++) { %>
            <% long taskId = tasks.get(t).getTaskId(); %>
            <tr>
                <td><%= t + 1 %>
                </td>
                <td><%= taskId %>
                </td>
                <td><%= tasks.get(t).getName() %>
                </td>
                <td><a href="/simpleservlet/tasks?type=delete&taskId=<%= taskId %>">delete</a></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <% } else { %>
    <div class="alert alert-warning">^^^ Use form below to create a task</div>
    <% } %>
</div>

</body>
</html>