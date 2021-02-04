
<%@ page import="league.Game" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-game" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-game" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="awayPoints" title="${message(code: 'game.awayPoints.label', default: 'Away Points')}" />
					
						<th><g:message code="game.awayTeam.label" default="Away Team" /></th>
					
						<g:sortableColumn property="date" title="${message(code: 'game.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="homePoints" title="${message(code: 'game.homePoints.label', default: 'Home Points')}" />
					
						<th><g:message code="game.homeTeam.label" default="Home Team" /></th>
					
						<g:sortableColumn property="location" title="${message(code: 'game.location.label', default: 'Location')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${gameInstanceList}" status="i" var="gameInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${gameInstance.id}">${fieldValue(bean: gameInstance, field: "awayPoints")}</g:link></td>
					
						<td>${fieldValue(bean: gameInstance, field: "awayTeam")}</td>
					
						<td><g:formatDate date="${gameInstance.date}" /></td>
					
						<td>${fieldValue(bean: gameInstance, field: "homePoints")}</td>
					
						<td>${fieldValue(bean: gameInstance, field: "homeTeam")}</td>
					
						<td>${fieldValue(bean: gameInstance, field: "location")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${gameInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
