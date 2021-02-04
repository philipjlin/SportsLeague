<%@ page import="league.League" %>



<div class="fieldcontain ${hasErrors(bean: leagueInstance, field: 'conferences', 'error')} ">
	<label for="conferences">
		<g:message code="league.conferences.label" default="Conferences" />
		
	</label>
	<g:select name="conferences" from="${cscie56.ps2.Conference.list()}" multiple="multiple" optionKey="id" size="5" value="${leagueInstance?.conferences*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: leagueInstance, field: 'leagueName', 'error')} required">
	<label for="leagueName">
		<g:message code="league.leagueName.label" default="League Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="leagueName" required="" value="${leagueInstance?.leagueName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: leagueInstance, field: 'leagueSize', 'error')} required">
	<label for="leagueSize">
		<g:message code="league.leagueSize.label" default="League Size" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="leagueSize" type="number" value="${leagueInstance.leagueSize}" required=""/>

</div>

