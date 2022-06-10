<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="repositories.Repository" %>
    <%@ page import="models.BeautyCompetition" %>
    <%@ page import="java.util.HashSet" %>
    <%@ page import="java.util.Set" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Регистрирани участници</title>
</head>
<body>
<% if(request.getAttribute("myCookie")!=null) { %>
<p> Участници в конкурса</p>

<%} %>
<%Repository rep= Repository.getInstance(); %>
<p>Благодарим за регистрацията, </p>
<%for(BeautyCompetition bc: rep.getParticipants()) {%>
<br><p> <%=bc %> </p>
<%} %>

</body>
</html>