<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
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
				<col>
				<tr>
					<td>Korisnik:</td>
				</tr>
				<tr>
					<td><form:select id="korisnikId" path="korisnikId">
							<option>Odaberite korisnika</option>
							<form:options items="${korisniciList}" itemLabel="punoIme"
								itemValue="id" />
						</form:select></td>
				</tr>
				<tr>
					<td>Bilježnica:</td>
				</tr>
				<tr>
					<td><form:select id="biljeznicaId" path="biljeznicaId">
					<option>Odaberite Bilježnicu</option>
							<form:options items="${biljezniceList}" itemLabel="naziv"
								itemValue="id" />
						</form:select></td>
				</tr>

				<tr>
					<td>Naslov:</td>
				</tr>
				<tr>
					<td><form:input path="naslov" id="naslov" /></td>
				</tr>

				<tr>
					<td>Tekst:</td>
				</tr>
				<tr>
					<td><form:textarea path="tekst" id="tekst" /></td>
				</tr>

				<tr>
					<td><form:button type="submit">Spremi</form:button></td>
				</tr>
			</table>
		</form:form>

		<table>
			<tr>
				<th>Bilježnica</th>
				<th>Broj unesenih bilješki</th>
			</tr>
			<c:forEach items="${biljeskaBrojac}" var="entry">
				<tr>
					<td>${entry.key}</td>
					<td>${entry.value}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<spring:url value="/novaBiljeskaResetiraj" />"><button>Obriši
				statistiku</button></a>
	</div>
</body>
</html>