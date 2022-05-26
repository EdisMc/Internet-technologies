<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ page import="models.Student" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Профил</title>
</head>
<body>
<% Student student = (Student)request.getAttribute("loggedStudent"); %>
<p> Факултетен номер: <%= student.getFacultyNumber() %></p>
<p> Име: <%= student.getName() %> </p>
<p> Курс: <%= student.getCourse() %> </p>
<p> Специалност: <%= student.getSpecialty() %> </p>
<p> Език: <%= student.getLanguage() %> </p>
</body>
</html>