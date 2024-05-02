<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Imposto de Curitiba</title>
</head>
<body>

	<nav id="menu">
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="CalcularSP.jsp">Imposto de São Paulo</a></li>
			<li><a href="CalcularBH.jsp">Imposto de Belo Horizonte</a></li>
			<li><a href="CalcularPA.jsp">Imposto de Porto Alegre</a></li>
			<li><a href="CalcularCR.jsp">Imposto de Curitiba</a></li>
		</ul>
	</nav>

	<div align="center">
		<form action="CR" method="post">
			<table>
				<tr>
					<td><input type="number" id="areaTotal" name="areaTotal"
						placeholder="Área Total do Imóvel" required="required"></td>
				</tr>
				<tr>
					<td><input type="number" min="0" step="1" id="idade"
						name="idade" placeholder="Idade do Imóvel"
						required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" id="consultar" name="consultar"
						value="consultar"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<br>
	<c:if test="${not empty imposto}">
		<div id="output" align="center">O valor total de imposto a pagar
			é ${imposto} reais.</div>
	</c:if>
</body>
</html>