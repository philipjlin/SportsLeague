
<%@ page import="league.GameStats" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'gameStats.label', default: 'GameStats')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-gameStats" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-gameStats" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list gameStats">
			
				<g:if test="${gameStatsInstance?.minutesPlayed}">
				<li class="fieldcontain">
					<span id="minutesPlayed-label" class="property-label"><g:message code="gameStats.minutesPlayed.label" default="Minutes Played" /></span>
					
						<span class="property-value" aria-labelledby="minutesPlayed-label"><g:fieldValue bean="${gameStatsInstance}" field="minutesPlayed"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.points}">
				<li class="fieldcontain">
					<span id="points-label" class="property-label"><g:message code="gameStats.points.label" default="Points" /></span>
					
						<span class="property-value" aria-labelledby="points-label"><g:fieldValue bean="${gameStatsInstance}" field="points"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.assists}">
				<li class="fieldcontain">
					<span id="assists-label" class="property-label"><g:message code="gameStats.assists.label" default="Assists" /></span>
					
						<span class="property-value" aria-labelledby="assists-label"><g:fieldValue bean="${gameStatsInstance}" field="assists"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.rebounds}">
				<li class="fieldcontain">
					<span id="rebounds-label" class="property-label"><g:message code="gameStats.rebounds.label" default="Rebounds" /></span>
					
						<span class="property-value" aria-labelledby="rebounds-label"><g:fieldValue bean="${gameStatsInstance}" field="rebounds"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.steals}">
				<li class="fieldcontain">
					<span id="steals-label" class="property-label"><g:message code="gameStats.steals.label" default="Steals" /></span>
					
						<span class="property-value" aria-labelledby="steals-label"><g:fieldValue bean="${gameStatsInstance}" field="steals"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.blocks}">
				<li class="fieldcontain">
					<span id="blocks-label" class="property-label"><g:message code="gameStats.blocks.label" default="Blocks" /></span>
					
						<span class="property-value" aria-labelledby="blocks-label"><g:fieldValue bean="${gameStatsInstance}" field="blocks"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.shotsAttempted}">
				<li class="fieldcontain">
					<span id="shotsAttempted-label" class="property-label"><g:message code="gameStats.shotsAttempted.label" default="Shots Attempted" /></span>
					
						<span class="property-value" aria-labelledby="shotsAttempted-label"><g:fieldValue bean="${gameStatsInstance}" field="shotsAttempted"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.shotsMade}">
				<li class="fieldcontain">
					<span id="shotsMade-label" class="property-label"><g:message code="gameStats.shotsMade.label" default="Shots Made" /></span>
					
						<span class="property-value" aria-labelledby="shotsMade-label"><g:fieldValue bean="${gameStatsInstance}" field="shotsMade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.shotsPercentage}">
				<li class="fieldcontain">
					<span id="shotsPercentage-label" class="property-label"><g:message code="gameStats.shotsPercentage.label" default="Shots Percentage" /></span>
					
						<span class="property-value" aria-labelledby="shotsPercentage-label"><g:fieldValue bean="${gameStatsInstance}" field="shotsPercentage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.threesAttempted}">
				<li class="fieldcontain">
					<span id="threesAttempted-label" class="property-label"><g:message code="gameStats.threesAttempted.label" default="Threes Attempted" /></span>
					
						<span class="property-value" aria-labelledby="threesAttempted-label"><g:fieldValue bean="${gameStatsInstance}" field="threesAttempted"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.threesMade}">
				<li class="fieldcontain">
					<span id="threesMade-label" class="property-label"><g:message code="gameStats.threesMade.label" default="Threes Made" /></span>
					
						<span class="property-value" aria-labelledby="threesMade-label"><g:fieldValue bean="${gameStatsInstance}" field="threesMade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.threesPercentage}">
				<li class="fieldcontain">
					<span id="threesPercentage-label" class="property-label"><g:message code="gameStats.threesPercentage.label" default="Threes Percentage" /></span>
					
						<span class="property-value" aria-labelledby="threesPercentage-label"><g:fieldValue bean="${gameStatsInstance}" field="threesPercentage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.personalFouls}">
				<li class="fieldcontain">
					<span id="personalFouls-label" class="property-label"><g:message code="gameStats.personalFouls.label" default="Personal Fouls" /></span>
					
						<span class="property-value" aria-labelledby="personalFouls-label"><g:fieldValue bean="${gameStatsInstance}" field="personalFouls"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.game}">
				<li class="fieldcontain">
					<span id="game-label" class="property-label"><g:message code="gameStats.game.label" default="Game" /></span>
					
						<span class="property-value" aria-labelledby="game-label"><g:link controller="game" action="show" id="${gameStatsInstance?.game?.id}">${gameStatsInstance?.game?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameStatsInstance?.person}">
				<li class="fieldcontain">
					<span id="person-label" class="property-label"><g:message code="gameStats.person.label" default="Person" /></span>
					
						<span class="property-value" aria-labelledby="person-label"><g:link controller="person" action="stats" id="${gameStatsInstance?.person?.id}">${gameStatsInstance?.person?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:gameStatsInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${gameStatsInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
