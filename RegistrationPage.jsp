<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Login</title>
</head>

<body>
		<h2>Регистрация на участници в национален курс за красота (6.06.2022г.)</h2>
			<form action="registration" method="post">
					<label for="name">Име на участника</label> 
					<input type="text"
						name="name" id="name"
						placeholder="Име на участника" /><br>
					<label for="lastName">Фамилия</label> 
					<input type="text"
						name="lastName" id="lastName"
						placeholder="Фамилия" /><br>
					<label for="age">Възраст</label> 
					<input type="text"
						name="age" id="age"
						placeholder="Възраст" /><br>
					<label for="city">Град</label>
					<input type="text"
						name="city" id="city"
						placeholder="Град" /><br>
					
				<input type="submit" value="Регистрирай се" />
			</form>
</body>
</html>