<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="atlantic.spprev.modelo.Cla"%>

<!DOCTYPE html>
<html>
<head>
<title>Cadastro de personagem</title>
<%
	List<Cla> cla = (List<Cla>) request.getAttribute("listacla");
%>
</head>
<body>
	<h1>Cadastrar Personagem</h1>
	<form action="/ConsultaOracleSQL/personagemformcad.haha?salvar=salvar" method="post"
		onload="false">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>NICK:</td>
				<td><input type="text" name="nick"></td>
			</tr>
			<tr>
				<td>LEVEL:</td>
				<td><input type="text" name="level"></td>
			</tr>
			<tr>
				<td>CLA:</td>
				<td><select name="ncla">
						<%
							for (int i = 0; i < cla.size(); i++) {
						%>
						<option value="<%=cla.get(i).getIdC()%>"><%=cla.get(i).getNome()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="salvar" value="Salvar"></td>
			</tr>
		</table>
	</form>
</body>
</html>