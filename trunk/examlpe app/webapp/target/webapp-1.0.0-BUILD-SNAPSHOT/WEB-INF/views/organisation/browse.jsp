<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header/header.jsp"%>

<div class="wrapper">
	<div style="border-bottom:3px solid #00AEEF;">
		<h3>Organisations</h3>
	</div>
	<c:if test="${not empty organisations}">
		<table id="projectResultTable" class="resultTable">
			<thead>
				<tr>
					<th width="380px">Name</th>
					<th width="250px">Country</th>
					<th>Website</th>
				</tr>
			</thead>		
			<tbody>
				<c:forEach items="${organisations}" var="organisation">
					<tr>
						<td><a href='<s:url value="/organisations/view/${organisation.id}"/>'>${organisation.name}</a></td>
						<td>${organisation.country}</td>
						<td>${organisation.url}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>

</body>
</html>