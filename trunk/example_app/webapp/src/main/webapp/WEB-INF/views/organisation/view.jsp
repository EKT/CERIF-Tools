<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../header/header.jsp"%>


<div class="wrapper">

	<c:if test="${not empty organisation}">
		<div style="border-bottom: 3px solid #00AEEF;">
			<h3>Organisation</h3>
		</div>
		<div id="accordion">
			<h3>${organisation.name}</h3>
			<div>
				<table class="library-table">
					<c:if test="${not empty organisation.name}">
						<tr>
							<td class="viewLeftColumn">Name</td>
							<td class="viewRightColumn">${organisation.name}</td>
						</tr>
					</c:if>
					
					<c:if test="${not empty organisation.country}">
						<tr>
							<td class="viewLeftColumn">Country</td>
							<td class="viewRightColumn">${organisation.country}</td>
						</tr>
					</c:if>
					
					<c:if test="${not empty organisation.url}">
						<tr>
							<td class="viewLeftColumn">URL</td>
							<td class="viewRightColumn">
								<c:choose>
									<c:when test="${!fn:contains(organisation.url,'http://')}">
										<a href="http://${organisation.url}" target="blank">
									</c:when>

									<c:otherwise>
										<a href="${organisation.url}" target="blank">
									</c:otherwise>

								</c:choose> ${organisation.url}</a></td>
						</tr>
					</c:if>

					<c:if test="${not empty organisation.address}">
						<tr>
							<td class="viewLeftColumn">Address</td>
							<td class="viewRightColumn">${organisation.address}</td>
						</tr>
					</c:if>
					
					<c:if test="${not empty organisation.telephone}">
						<tr>
							<td class="viewLeftColumn">Telephone Number</td>
							<td class="viewRightColumn">${organisation.telephone}</td>
						</tr>
					</c:if>
					
					<c:if test="${not empty organisation.type}">
						<tr>
							<td class="viewLeftColumn">Type</td>
							<td class="viewRightColumn">
								${organisation.type.term}
							</td>
						</tr>
					</c:if>

					<c:if test="${not empty organisation.projects['Partner']}">
	  	  				<tr>
							<td class="viewLeftColumn">Partner to Projects</td>				  
							<td class="viewRightColumn">
								<c:forEach items="${organisation.projects['Partner']}" var="partner" varStatus="status"><a href='<s:url value="/projects/view/${partner.id}"/>'>${partner.title}</a><c:if test="${!status.last}">, </c:if>	
								</c:forEach>				
							</td>				  
			  			</tr>
	  	  			</c:if>	
					
					<c:if test="${not empty organisation.projects['Coordinator']}">
	  	  				<tr>
							<td class="viewLeftColumn">Coordinator to Projects</td>				  
							<td class="viewRightColumn">
								<c:forEach items="${organisation.projects['Coordinator']}" var="coordinator" varStatus="status"><a href='<s:url value="/projects/view/${coordinator.id}"/>'>${coordinator.title}</a><c:if test="${!status.last}">, </c:if>	
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
