<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header/header.jsp"%>


<div class="wrapper">

	<c:if test="${not empty project}">
		<div style="border-bottom:3px solid #00AEEF;">
			<h3>Project</h3>
		</div>
		<div id="accordion">

			<h3>${project.acronym}</h3>
			<div>
				<table class="library-table">
					<c:if test="${not empty project.title}">
						<tr>
							<td class="viewLeftColumn">Title</td>
							<td class="viewRightColumn">${project.title}</td>
						</tr>
					</c:if>

					<c:if test="${not empty project.startDate}">
						<tr>
							<td class="viewLeftColumn">Dates</td>
							<td class="viewRightColumn"><fmt:formatDate	pattern="dd/MM/yyyy" value="${project.startDate}" />
								<c:if test="${not empty project.endDate}"> - <fmt:formatDate pattern="dd/MM/yyyy" value="${project.endDate}" /></c:if>
							</td>
						</tr>
					</c:if>


					<c:if test="${not empty project.scientificDomain}">
						<tr>
							<td class="viewLeftColumn">Scientific Domain</td>
							<td class="viewRightColumn">
								${project.scientificDomain.term}
							</td>
						</tr>
					</c:if>

					<c:if test="${not empty project.abstractText}">
						<tr>
							<td class="viewLeftColumn">Abstract</td>
							<td class="viewRightColumn">${project.abstractText}</td>
						</tr>
					</c:if>

					<c:if test="${not empty project.organisations['Partner']}">
	  	  				<tr>
							<td class="viewLeftColumn">Partner Organisations</td>				  
							<td class="viewRightColumn">
								<c:forEach items="${project.organisations['Partner']}" var="partner" varStatus="status"><a href='<s:url value="/organisations/view/${partner.id}"/>'>${partner.name}</a><c:if test="${!status.last}">, </c:if>	
								</c:forEach>				
							</td>				  
			  			</tr>
	  	  			</c:if>	
					
					<c:if test="${not empty project.organisations['Coordinator']}">
	  	  				<tr>
							<td class="viewLeftColumn">Coordinator Organisations</td>				  
							<td class="viewRightColumn">
								<c:forEach items="${project.organisations['Coordinator']}" var="coordinator" varStatus="status"><a href='<s:url value="/organisations/view/${coordinator.id}"/>'>${coordinator.name}</a><c:if test="${!status.last}">, </c:if>	
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
