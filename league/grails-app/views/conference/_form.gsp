<%@ page import="league.Conference" %>



<div class="fieldcontain ${hasErrors(bean: conferenceInstance, field: 'conferenceName', 'error')} required">
	<label for="conferenceName">
		<g:message code="conference.conferenceName.label" default="Conference Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="conferenceName" required="" value="${conferenceInstance?.conferenceName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: conferenceInstance, field: 'teams', 'error')} ">
	<label for="teams">
		<g:message code="conference.teams.label" default="Teams" />
		
	</label>
	<g:select name="teams" from="${cscie56.ps2.Team.list()}" multiple="multiple" optionKey="id" size="5" value="${conferenceInstance?.teams*.id}" class="many-to-many"/>

</div>

