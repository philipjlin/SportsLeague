
<%@ page import="league.GameStats" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'gameStats.label', default: 'GameStats')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-gameStats" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-gameStats" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="minutesPlayed" title="${message(code: 'gameStats.minutesPlayed.label', default: 'Minutes Played')}" />
					
						<g:sortableColumn property="points" title="${message(code: 'gameStats.points.label', default: 'Points')}" />
					
						<g:sortableColumn property="assists" title="${message(code: 'gameStats.assists.label', default: 'Assists')}" />
					
						<g:sortableColumn property="rebounds" title="${message(code: 'gameStats.rebounds.label', default: 'Rebounds')}" />
					
						<g:sortableColumn property="steals" title="${message(code: 'gameStats.steals.label', default: 'Steals')}" />
					
						<g:sortableColumn property="blocks" title="${message(code: 'gameStats.blocks.label', default: 'Blocks')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${gameStatsInstanceList}" status="i" var="gameStatsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${gameStatsInstance.id}">${fieldValue(bean: gameStatsInstance, field: "minutesPlayed")}</g:link></td>
					
						<td>${fieldValue(bean: gameStatsInstance, field: "points")}</td>
					
						<td>${fieldValue(bean: gameStatsInstance, field: "assists")}</td>
					
						<td>${fieldValue(bean: gameStatsInstance, field: "rebounds")}</td>
					
						<td>${fieldValue(bean: gameStatsInstance, field: "steals")}</td>
					
						<td>${fieldValue(bean: gameStatsInstance, field: "blocks")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${gameStatsInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
