<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Nova biljeska</title>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/resources/css/style.css" />">
</head>
<body>
	<div id="container">
		<h1>Nova Bilješka</h1>
		<form:form method="POST" modelAttribute="novaBiljeskaForm">
			<table>
				<tr>
					<td>Korisnik:</td>
					<td><form:select id="" path="korisnikId">
							<form:options items="${korisniciList}" itemLabel="punoIme"
								itemValue="id" />
						</form:select></td>
				</tr>
				<tr>
					<td>Korisnik:</td>
					<td><form:select id="biljeznicaId" path="biljeznicaId">
							<form:options items="${biljezniceList}" itemLabel="naziv"
								itemValue="id" />
						</form:select></td>
				</tr>

				<tr>
					<td>Naslov:</td>

					<td><form:input path="naslov" id="naslov" /></td>

				</tr>

				<tr>
					<td>Tekst:</td>
					<td><form:textarea path="tekst" id="tekst" /></td>
				</tr>
				<tr>
					<td><form:button type="submit">Spremi</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>