<%@ page import="cscie56.ps2.Team" %>



<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'coaches', 'error')} required">
	<label for="coaches">
		<g:message code="team.coaches.label" default="Coaches" />
		<span class="required-indicator">*</span>
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'persons', 'error')} ">
	<label for="persons">
		<g:message code="team.persons.label" default="Persons" />
		
	</label>
	<g:select name="persons" from="${cscie56.ps2.Person.list()}" multiple="multiple" optionKey="id" size="5" value="${teamInstance?.persons*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'roster', 'error')} required">
	<label for="roster">
		<g:message code="team.roster.label" default="Roster" />
		<span class="required-indicator">*</span>
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'teamName', 'error')} required">
	<label for="teamName">
		<g:message code="team.teamName.label" default="Team Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="teamName" required="" value="${teamInstance?.teamName}"/>

</div>

