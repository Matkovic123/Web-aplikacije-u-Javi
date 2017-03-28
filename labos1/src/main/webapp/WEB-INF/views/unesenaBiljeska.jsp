<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%><html>
<head>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/resources/css/style.css" />">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pregled unesene biljeske</title>
</head>
<body>
	<div id="container">
		<h1>${biljeska.naslov}</h1>
		<div>
			<p>${biljeska.tekst}</p>
		</div>
		<p>Napisao: ${biljeska.korisnik.punoIme} , korisničko ime:
			${biljeska.korisnik.korisnickoIme}</p>
		<p>
			Nalazite se u bilježnici <span title="${biljeska.biljeznica.opis}">
				${biljeska.biljeznica.naziv} </span>
		</p>
		<a href="<spring:url value="/novaBiljeska" />">Povratak</a>
	</div>
</body>
</html>