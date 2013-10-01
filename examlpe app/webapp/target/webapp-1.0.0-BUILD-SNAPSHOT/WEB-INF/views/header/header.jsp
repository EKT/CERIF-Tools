<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<style type="text/css">    
   		@import "<s:url value='/resources/css/styles.css'/>";
	</style>
	<title>Test Application </title>
</head>
<body>
<h1>
	<a href='<s:url value="/"/>'>Example application for <a href="https://code.google.com/p/cerif-jpa-persistence/">cerif-jpa-persistence</a></a>
</h1>

	<div id="main_menu">
		<ul>
			<li style="width: 100px"><a class="simple"
				href='<s:url value="/projects/browse" />'>Projects</a></li>
			<li style="width: 120px"><a class="simple"
				href='<s:url value="/organisations/browse" />'>Organisations</a></li>
		</ul>
	</div>

