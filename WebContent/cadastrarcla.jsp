<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar CLÃ</title>
</head>
<body>
	<h1>Cadastrar Clã</h1>
	<form action="/ConsultaOracleSQL/clacad.haha" method="post"
		onload="false">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>NOME:</td>
				<td><input type="text" name="nick"></td>
			</tr>
			<tr>
				<td><input type="submit" name="salvarCla" value="salvar"></td>
			</tr>
		</table>
	</form>
</body>
</html>