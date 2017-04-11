<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%><html>

<head>
<title>Potvrdi Biljesku</title>
<link href="<spring:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<p>Korisnik: ${korisnickoIme}</p>
		<p>Bilježnica: ${biljeznicaIme}</p>
		<p>Nalsov: ${novaBiljeskaForm.naslov}</p>
		<p>Tekst: ${novaBiljeskaForm.tekst}</p>
	</div>
	<div>
		<a href="<spring:url value="/editBiljeska"/>"><button>Povratak</button></a> <a
			href="<spring:url value="/spremiBiljesku"/>"><button>Spremi</button></a>
	</div>
</body>
</html>