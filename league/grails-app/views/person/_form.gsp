<%@ page import="league.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="person.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${personInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="person.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${personInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="person.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="role" required="" value="${personInstance?.role}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'bio', 'error')} ">
	<label for="bio">
		<g:message code="person.bio.label" default="Bio" />
		
	</label>
	<g:textField name="bio" value="${personInstance?.bio}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'birthPlace', 'error')} ">
	<label for="birthPlace">
		<g:message code="person.birthPlace.label" default="Birth Place" />
		
	</label>
	<g:textField name="birthPlace" value="${personInstance?.birthPlace}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'birthDate', 'error')} ">
	<label for="birthDate">
		<g:message code="person.birthDate.label" default="Birth Date" />
		
	</label>
	<g:datePicker name="birthDate" precision="day"  value="${personInstance?.birthDate}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'height', 'error')} ">
	<label for="height">
		<g:message code="person.height.label" default="Height" />
		
	</label>
	<g:textField name="height" value="${personInstance?.height}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'weight', 'error')} ">
	<label for="weight">
		<g:message code="person.weight.label" default="Weight" />
		
	</label>
	<g:textField name="weight" value="${personInstance?.weight}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'universityAttended', 'error')} ">
	<label for="universityAttended">
		<g:message code="person.universityAttended.label" default="University Attended" />
		
	</label>
	<g:textField name="universityAttended" value="${personInstance?.universityAttended}"/>

</div>

