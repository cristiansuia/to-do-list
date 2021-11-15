<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To Do List</title>
</head>
<body>
	<c:url var="remove_task_url" value="delete"/>
	 Here are the list of your tasks ${username}:
	 <br>	 
	 
	 <table>
	    <c:forEach items="${tasks}" var="task">
	    <tr>
	       <td><c:out value="${task.id}"/></td> 
	       <td><c:out value="${task.desc}"/></td>
	       <td><c:out value="${task.lastUpdate}"/></td>
	       <td><input name="isDone" id="isDone" value="0" type="checkbox" value=task.isDone/></td>
	    </tr>
	    </c:forEach>
	    
	</table>
	<a href="/addTask">Add task</a>
	<a href="/login">Logout</a>
</body>
</html>