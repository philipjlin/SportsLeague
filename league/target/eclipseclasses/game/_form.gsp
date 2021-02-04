<%@ page import="cscie56.ps2.Game" %>



<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'awayPoints', 'error')} required">
	<label for="awayPoints">
		<g:message code="game.awayPoints.label" default="Away Points" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="awayPoints" type="number" value="${gameInstance.awayPoints}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'awayTeam', 'error')} required">
	<label for="awayTeam">
		<g:message code="game.awayTeam.label" default="Away Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="awayTeam" name="awayTeam.id" from="${cscie56.ps2.Team.list()}" optionKey="id" required="" value="${gameInstance?.awayTeam?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="game.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${gameInstance?.date}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'homePoints', 'error')} required">
	<label for="homePoints">
		<g:message code="game.homePoints.label" default="Home Points" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="homePoints" type="number" value="${gameInstance.homePoints}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'homeTeam', 'error')} required">
	<label for="homeTeam">
		<g:message code="game.homeTeam.label" default="Home Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="homeTeam" name="homeTeam.id" from="${cscie56.ps2.Team.list()}" optionKey="id" required="" value="${gameInstance?.homeTeam?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'location', 'error')} required">
	<label for="location">
		<g:message code="game.location.label" default="Location" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="location" required="" value="${gameInstance?.location}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'teams', 'error')} ">
	<label for="teams">
		<g:message code="game.teams.label" default="Teams" />
		
	</label>
	<g:select name="teams" from="${cscie56.ps2.Team.list()}" multiple="multiple" optionKey="id" size="5" value="${gameInstance?.teams*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'time', 'error')} required">
	<label for="time">
		<g:message code="game.time.label" default="Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="time" required="" value="${gameInstance?.time}"/>

</div>

