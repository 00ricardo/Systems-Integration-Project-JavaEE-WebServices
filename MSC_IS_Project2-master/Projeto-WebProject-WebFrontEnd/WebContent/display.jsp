<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- External Links -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Projeto 2 - Web front-end - Integração de Sistemas</title>
</head>
<style>
body {
	background: #464848;
}

.tilesWrap {
	padding: 0;
	margin: 50px auto;
	list-style: none;
	text-align: center;
}

.tilesWrap li {
	display: inline-block;
	width: 20%;
	min-width: 200px;
	max-width: 230px;
	padding: 80px 20px 40px;
	position: relative;
	vertical-align: top;
	margin: 10px;
	font-family: 'helvetica', san-serif;
	min-height: 25vh;
	background: #262a2b;
	border: 1px solid #252727;
	text-align: left;
}

.tilesWrap li h2 {
	font-size: 114px;
	margin: 0;
	position: absolute;
	opacity: 0.2;
	top: 50px;
	right: 10px;
	transition: all 0.3s ease-in-out;
}

.tilesWrap li h3 {
	font-size: 20px;
	color: #b7b7b7;
	margin-bottom: 5px;
}

.tilesWrap li p {
	font-size: 16px;
	line-height: 18px;
	color: #b7b7b7;
	margin-top: 5px;
}

.tilesWrap li button {
	background: transparent;
	border: 1px solid #b7b7b7;
	padding: 10px 20px;
	color: #b7b7b7;
	border-radius: 3px;
	position: relative;
	transition: all 0.3s ease-in-out;
	transform: translateY(-40px);
	opacity: 0;
	cursor: pointer;
	overflow: hidden;
}

.tilesWrap li button:before {
	content: '';
	position: absolute;
	height: 100%;
	width: 120%;
	background: #b7b7b7;
	top: 0;
	opacity: 0;
	left: -140px;
	border-radius: 0 20px 20px 0;
	z-index: -1;
	transition: all 0.3s ease-in-out;
}

.tilesWrap li:hover button {
	transform: translateY(5px);
	opacity: 1;
}

.tilesWrap li button:hover {
	color: #262a2b;
}

.tilesWrap li button:hover:before {
	left: 0;
	opacity: 1;
}

.tilesWrap li:hover h2 {
	top: 0px;
	opacity: 0.6;
}

.tilesWrap li:before {
	content: '';
	position: absolute;
	top: -2px;
	left: -2px;
	right: -2px;
	bottom: -2px;
	z-index: -1;
	background: #fff;
	transform: skew(2deg, 2deg);
}

.tilesWrap li:after {
	content: '';
	position: absolute;
	width: 40%;
	height: 100%;
	left: 0;
	top: 0;
	background: rgba(255, 255, 255, 0.02);
}

.tilesWrap li:nth-child(odd):before {
	background: #C9FFBF;
	background: -webkit-linear-gradient(to right, #FFAFBD, #C9FFBF);
	background: linear-gradient(to right, #FFAFBD, #C9FFBF);
}

.tilesWrap li:nth-child(even):before {
	background: #FC354C;
	background: -webkit-linear-gradient(to right, #0ABFBC, #FC354C);
	background: linear-gradient(to right, #0ABFBC, #FC354C);
}
</style>


<body>
	<br>
	<h3 style="color: darkgrey; text-align: center;">Publications</h3>
	<ul class="tilesWrap">
	<div class="accordion" id="accordionExample">
	<c:forEach var="pub" items="${publications}">
	 	<c:set var = "code1" value = "${fn:split(pub.publication_title, ' ')}" />
		<c:set var = "code2" value = "${fn:split(pub.publication_Date, ' ')}" />
		<c:set var = "code3" value = "${pub.reads}" />
		<li>
			<h3>${pub.publication_title}</h3><br>
			
			 <h3>${string3[0]}</h3>	
			<p>Authors: </p>
			<c:forEach var="res" items="${pub.researchers}">
				<p><small style="color: #252727; color: darkgrey; font-style: italic;">${res.firstName} ${res.lastName}</small></p>
			</c:forEach>
			<button class="btn btn-link collapsed" type="button"
				data-toggle="collapse" data-target="#${code1[0]}${code2[1]}${code3}"
				aria-expanded="false" aria-controls="${code1[0]}${code2[1]}${code3}">Read more</button>
		</li>
	</c:forEach>
	 </div>
	</ul>

<c:forEach var="pub" items="${publications}">
		<c:set var = "code1" value = "${fn:split(pub.publication_title, ' ')}" />
		<c:set var = "code2" value = "${fn:split(pub.publication_Date, ' ')}" />
		<c:set var = "code3" value = "${pub.reads}" />
	<div class="tilesWrap">
		<div id="${code1[0]}${code2[1]}${code3}" class="collapse" aria-labelledby="headingTwo">
			
				<div class="card-body" style="color: darkgrey">
					Authors description <hr>
					<c:forEach var="res" items="${pub.researchers}">
						${res.firstName} ${res.lastName} : ${res.description}
						<br>	
					</c:forEach>
					
					<br><br>Publication description <hr>
					Reads: ${pub.reads}<br>
					Recommendations: ${pub.recommendations}<br>
					Citations: ${pub.citations}<br>
					Published in ${pub.publication_Date}
				</div>
		</div>
	</div>
	
</c:forEach>



</body>

<div style="position: inherit; bottom: 0px;">
	<small
		style="color: #252727; font-size: initial; font-style: italic; color: darkgrey">Projeto
		2 - Web front-end - Integração de Sistemas</small><br> <small
		style="color: #252727; color: darkgrey; font-style: italic;">Developed
		by David Paiva and Ricardo Briceño</a>
	</small>
</div>
<!-- External Scripts -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

</html>