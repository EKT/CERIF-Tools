<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../header/header.jsp"%>


<div class="wrapper">

	<c:if test="${not empty person}">
		<div style="border-bottom: 3px solid #00AEEF;">
			<h3>Person</h3>
		</div>
		<div id="accordion">
			<h3>${person.lastName} ${person.firstName}</h3>
			<div>
				<table class="library-table">
					<c:if test="${not empty person.lastName}">
						<tr>
							<td class="viewLeftColumn">Name</td>
							<td class="viewRightColumn">${person.lastName} ${person.firstName}</td>
						</tr>
					</c:if>
					
					<c:if test="${not empty person.organisations}">
	  	  				<tr>
							<td class="viewLeftColumn">Organisations</td>				  
							<td class="viewRightColumn">
								<c:forEach items="${person.organisations}" var="org" varStatus="status"><a href='<s:url value="/organisations/view/${org.id}"/>'>${org.name}</a> (${org.personRole})<c:if test="${!status.last}">, </c:if>	
								</c:forEach>				
							</td>				  
			  			</tr>
	  	  			</c:if>

				</table>
			</div>



		</div>

	</c:if>

</div>

</body>
</html>
