<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Формуляр за олимпиада по математика</title>
</head>
<body>
		<h1>Създаване на профил</h1>
			<form action="registration" method="post">
					<label for="faculty-number">Факултетен номер</label> <input type="text"
						name="faculty-number" id="faculty-number"
						placeholder="Въведете факултетен номер" /><br>
					<label for="name">Име</label> <input type="text"
						name="name" id="name"
						placeholder="Въведете име" /><br>
					<label for="course">Курс</label> <input type="text"
						name="course" id="course"
						placeholder="Въведете курс" /><br>
					<label for="specialty">Специалност</label> <input
						type="text" name="specialty" id="specialty"
						placeholder="Въведете специалност" /><br>
					<label for="specialty">Език за програмиране</label> 
					<input type="radio" name="language" id="java"
						value="java" />Java
					<input type="radio" name="language" id="cpp"
						value="cpp" />C++<br>
				<input type="submit" value="Давай" />
		</form>
</body>
</html>