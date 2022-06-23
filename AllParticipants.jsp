<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="repositories.ParticipantRepository" %>
<%@ page import="models.Participant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrirani</title>
</head>
<body>

	<% ParticipantRepository repository = ParticipantRepository.getInstance(); %>
	<% for (Participant participant : repository.getParticipants()) { %>
	<%= participant.getName() %>
	<%= participant.getJob() %>
	<%= participant.getReason() %>
	<% } %>
	
</body>
</html>