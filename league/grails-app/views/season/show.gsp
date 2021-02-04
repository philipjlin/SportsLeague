
<%@ page import="league.Season" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'season.label', default: 'Season')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-season" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-season" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list season">
			
				<g:if test="${seasonInstance?.seasonEnd}">
				<li class="fieldcontain">
					<span id="seasonEnd-label" class="property-label"><g:message code="season.seasonEnd.label" default="Season End" /></span>
					
						<span class="property-value" aria-labelledby="seasonEnd-label"><g:formatDate date="${seasonInstance?.seasonEnd}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${seasonInstance?.seasonName}">
				<li class="fieldcontain">
					<span id="seasonName-label" class="property-label"><g:message code="season.seasonName.label" default="Season Name" /></span>
					
						<span class="property-value" aria-labelledby="seasonName-label"><g:fieldValue bean="${seasonInstance}" field="seasonName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${seasonInstance?.seasonStart}">
				<li class="fieldcontain">
					<span id="seasonStart-label" class="property-label"><g:message code="season.seasonStart.label" default="Season Start" /></span>
					
						<span class="property-value" aria-labelledby="seasonStart-label"><g:formatDate date="${seasonInstance?.seasonStart}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:seasonInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${seasonInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
