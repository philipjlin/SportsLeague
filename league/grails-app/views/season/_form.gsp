<%@ page import="league.Season" %>



<div class="fieldcontain ${hasErrors(bean: seasonInstance, field: 'seasonEnd', 'error')} required">
	<label for="seasonEnd">
		<g:message code="season.seasonEnd.label" default="Season End" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="seasonEnd" precision="day"  value="${seasonInstance?.seasonEnd}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: seasonInstance, field: 'seasonName', 'error')} required">
	<label for="seasonName">
		<g:message code="season.seasonName.label" default="Season Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="seasonName" required="" value="${seasonInstance?.seasonName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: seasonInstance, field: 'seasonStart', 'error')} required">
	<label for="seasonStart">
		<g:message code="season.seasonStart.label" default="Season Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="seasonStart" precision="day"  value="${seasonInstance?.seasonStart}"  />

</div>

