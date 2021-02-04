<%@ page import="league.GameStats" %>



<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'minutesPlayed', 'error')} required">
	<label for="minutesPlayed">
		<g:message code="gameStats.minutesPlayed.label" default="Minutes Played" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minutesPlayed" type="number" min="0" value="${gameStatsInstance.minutesPlayed}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'points', 'error')} required">
	<label for="points">
		<g:message code="gameStats.points.label" default="Points" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="points" type="number" min="0" value="${gameStatsInstance.points}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'assists', 'error')} required">
	<label for="assists">
		<g:message code="gameStats.assists.label" default="Assists" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="assists" type="number" min="0" value="${gameStatsInstance.assists}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'rebounds', 'error')} required">
	<label for="rebounds">
		<g:message code="gameStats.rebounds.label" default="Rebounds" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rebounds" type="number" min="0" value="${gameStatsInstance.rebounds}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'steals', 'error')} required">
	<label for="steals">
		<g:message code="gameStats.steals.label" default="Steals" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="steals" type="number" min="0" value="${gameStatsInstance.steals}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'blocks', 'error')} required">
	<label for="blocks">
		<g:message code="gameStats.blocks.label" default="Blocks" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blocks" type="number" min="0" value="${gameStatsInstance.blocks}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'shotsAttempted', 'error')} required">
	<label for="shotsAttempted">
		<g:message code="gameStats.shotsAttempted.label" default="Shots Attempted" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="shotsAttempted" type="number" min="0" value="${gameStatsInstance.shotsAttempted}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'shotsMade', 'error')} required">
	<label for="shotsMade">
		<g:message code="gameStats.shotsMade.label" default="Shots Made" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="shotsMade" type="number" min="0" value="${gameStatsInstance.shotsMade}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'shotsPercentage', 'error')} required">
	<label for="shotsPercentage">
		<g:message code="gameStats.shotsPercentage.label" default="Shots Percentage" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="shotsPercentage" type="number" min="0" value="${gameStatsInstance.shotsPercentage}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'threesAttempted', 'error')} required">
	<label for="threesAttempted">
		<g:message code="gameStats.threesAttempted.label" default="Threes Attempted" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="threesAttempted" type="number" min="0" value="${gameStatsInstance.threesAttempted}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'threesMade', 'error')} required">
	<label for="threesMade">
		<g:message code="gameStats.threesMade.label" default="Threes Made" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="threesMade" type="number" min="0" value="${gameStatsInstance.threesMade}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'threesPercentage', 'error')} required">
	<label for="threesPercentage">
		<g:message code="gameStats.threesPercentage.label" default="Threes Percentage" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="threesPercentage" type="number" min="0" value="${gameStatsInstance.threesPercentage}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'personalFouls', 'error')} required">
	<label for="personalFouls">
		<g:message code="gameStats.personalFouls.label" default="Personal Fouls" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="personalFouls" type="number" min="0" value="${gameStatsInstance.personalFouls}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'game', 'error')} required">
	<label for="game">
		<g:message code="gameStats.game.label" default="Game" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="game" name="game.id" from="${cscie56.ps2.Game.list()}" optionKey="id" required="" value="${gameStatsInstance?.game?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameStatsInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="gameStats.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${cscie56.ps2.Person.list()}" optionKey="id" required="" value="${gameStatsInstance?.person?.id}" class="many-to-one"/>

</div>

