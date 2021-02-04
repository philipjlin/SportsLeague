
<%@ page import="cscie56.ps2.League" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'league.label', default: 'League')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-league" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-league" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list league">
			
				<g:if test="${leagueInstance?.conferences}">
				<li class="fieldcontain">
					<span id="conferences-label" class="property-label"><g:message code="league.conferences.label" default="Conferences" /></span>
					
						<g:each in="${leagueInstance.conferences}" var="c">
						<span class="property-value" aria-labelledby="conferences-label"><g:link controller="conference" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${leagueInstance?.leagueName}">
				<li class="fieldcontain">
					<span id="leagueName-label" class="property-label"><g:message code="league.leagueName.label" default="League Name" /></span>
					
						<span class="property-value" aria-labelledby="leagueName-label"><g:fieldValue bean="${leagueInstance}" field="leagueName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${leagueInstance?.leagueSize}">
				<li class="fieldcontain">
					<span id="leagueSize-label" class="property-label"><g:message code="league.leagueSize.label" default="League Size" /></span>
					
						<span class="property-value" aria-labelledby="leagueSize-label"><g:fieldValue bean="${leagueInstance}" field="leagueSize"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:leagueInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${leagueInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
