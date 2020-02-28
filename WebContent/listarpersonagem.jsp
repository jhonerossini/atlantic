<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page import="atlantic.spprev.modelo.Personagem"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de personagens</title>
<%
	List<Personagem> p = (List<Personagem>) request.getAttribute("lista");
%>
</head>
<body>
	<table border="2">
		<%
			for (int i = 0; i < p.size(); i++) {
		%>
		<tr>
			<td>ID:</td>
			<td><%=p.get(i).getIdP()%></td>
		</tr>
		<tr>
			<td>NICK:</td>
			<td><%=p.get(i).getNick()%></td>
		</tr>
		<tr>
			<td>LEVEL:</td>
			<td><%=p.get(i).getLevelP()%></td>
		</tr>
		<tr>
			<td>Clã:</td>
			<td><%=p.get(i).getNome()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>