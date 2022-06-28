<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "repositories.PartRepository" %>
<%@ page import = "models.Participant" %>
<%@ page import = "java.util.Set" %>
<%@ page import = "java.util.HashSet" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All participants</title>
</head>
<body>

<% PartRepository repository = PartRepository.getInstance(); %>
<p>Номинирани:</p>
<% for (Participant part : repository.getParticipants()) { %>
<br><p> <%=part %> </p>
<% } %>


</body>
</html>