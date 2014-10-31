<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header/header.jsp"%>

<div class="wrapper">
	<div style="border-bottom:3px solid #00AEEF;">
		<h3>Persons</h3>
	</div>
	<c:if test="${not empty persons}">
		<table id="personResultTable" class="resultTable">
			<thead>
				<tr>
					<th width="380px">Name</th>
					<th>Organisation(s)</th>
				</tr>
			</thead>		
			<tbody>
				<c:forEach items="${persons}" var="person">
					<tr>
						<td><a href='<s:url value="/persons/view/${person.id}"/>'>${person.lastName} ${person.firstName}</a></td>
						<td>
							<c:choose>
								<c:when test="${not empty person.organisations}">
									<c:forEach items="${person.organisations}" var="org" varStatus="status"><a href='<s:url value="/organisations/view/${org.id}"/>'>${org.name}</a> (${org.personRole})<c:if test="${!status.last}">, </c:if>	
									</c:forEach>
								</c:when>
								<c:otherwise>
									-
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>

</body>
</html>