<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add New Task</title>
    </head>
    <body>
        <c:url var="add_task_url" value="addTask"/>
        <h1>New Task</h1>
        <form:form action="${add_task_url}" method="post" modelAttribute="task">
            <form:label path="desc">Task Description: </form:label> <form:input type="text" path="desc"/>
            <input type="submit" value="submit"/>
        </form:form>
      	<a href="/login">Logout</a>
    </body>
</html>