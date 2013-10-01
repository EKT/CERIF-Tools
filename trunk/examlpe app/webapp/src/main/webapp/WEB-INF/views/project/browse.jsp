<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header/header.jsp"%>

<div class="wrapper">
	<div style="border-bottom:3px solid #00AEEF;">
		<h3>Projects</h3>
	</div>
	<c:if test="${not empty projects}">
		<table id="projectResultTable" class="resultTable">
			<thead>
				<tr>
					<th width="120px">Acronym</th>
					<th width="370px">Title</th>
					<th width="220px">Dates</th>
					<th>Domain</th>
				</tr>
			</thead>		
			<tbody>
				<c:forEach items="${projects}" var="project">
					<tr>
						<td><a href='<s:url value="/projects/view/${project.id}"/>'>${project.acronym}</a></td>
						<td>${project.title}</td>
						<td>
							<fmt:formatDate pattern="dd/MM/yyyy" value="${project.startDate}" /><c:if test="${not empty project.endDate}"> - <fmt:formatDate pattern="dd/MM/yyyy" value="${project.endDate}" /></c:if>
						</td>
						<td>${project.scientificDomain.term}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>

</body>
</html>