
<%@ page import="league.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>

		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person">
			
				<g:if test="${personInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="person.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${personInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="person.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${personInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.role}">
				<li class="fieldcontain">
					<span id="role-label" class="property-label"><g:message code="person.role.label" default="Role" /></span>
					
						<span class="property-value" aria-labelledby="role-label"><g:fieldValue bean="${personInstance}" field="role"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.bio}">
				<li class="fieldcontain">
					<span id="bio-label" class="property-label"><g:message code="person.bio.label" default="Bio" /></span>
					
						<span class="property-value" aria-labelledby="bio-label"><g:fieldValue bean="${personInstance}" field="bio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.birthPlace}">
				<li class="fieldcontain">
					<span id="birthPlace-label" class="property-label"><g:message code="person.birthPlace.label" default="Birth Place" /></span>
					
						<span class="property-value" aria-labelledby="birthPlace-label"><g:fieldValue bean="${personInstance}" field="birthPlace"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.birthDate}">
				<li class="fieldcontain">
					<span id="birthDate-label" class="property-label"><g:message code="person.birthDate.label" default="Birth Date" /></span>
					
						<span class="property-value" aria-labelledby="birthDate-label"><g:formatDate format="MM-dd-yyyy" date="${personInstance?.birthDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.height}">
				<li class="fieldcontain">
					<span id="height-label" class="property-label"><g:message code="person.height.label" default="Height" /></span>
					
						<span class="property-value" aria-labelledby="height-label"><g:fieldValue bean="${personInstance}" field="height"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.weight}">
				<li class="fieldcontain">
					<span id="weight-label" class="property-label"><g:message code="person.weight.label" default="Weight" /></span>
					
						<span class="property-value" aria-labelledby="weight-label"><g:fieldValue bean="${personInstance}" field="weight"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.universityAttended}">
				<li class="fieldcontain">
					<span id="universityAttended-label" class="property-label"><g:message code="person.universityAttended.label" default="University Attended" /></span>
					
						<span class="property-value" aria-labelledby="universityAttended-label"><g:fieldValue bean="${personInstance}" field="universityAttended"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:personInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${personInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
