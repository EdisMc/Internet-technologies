<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<h2>„Шахматист на Варна за м. 06.2022 г.“</h2>
	<form action="registration" method="post">
		<input type="text" name="id" size = "30" placeholder="FIDE ID"/> <br/><br/>
		<input type="text" name="nameSch" size ="30 "placeholder="Име на шахматиста"/> <br/><br/>
		<input type="text" name="nameNom" size = "30" placeholder="Име на номиниралото лице"/> <br/><br/>
		<input type="text" name="vote" size = "30" placeholder="Гласувай"/> <br/><br/>

		<input type="submit" value="Регистрирай" />
	</form>

</body>
</html>
