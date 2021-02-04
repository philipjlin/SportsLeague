<%@ page import="league.User" %>



<div class="fieldcontain ${hasErrors(bean: user, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="user.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${user?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: user, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="user.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${user?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: user, field: 'blogEntries', 'error')} ">
	<label for="blogEntries">
		<g:message code="user.blogEntries.label" default="Blog Entries" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${user?.blogEntries?}" var="b">
    <li><g:link controller="blogEntry" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="blogEntry" action="create" params="['user.id': user?.id]">${message(code: 'default.add.label', args: [message(code: 'blogEntry.label', default: 'BlogEntry')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: user, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="user.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${user?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: user, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${user?.password}" />

</div>

<div class="fieldcontain ${hasErrors(bean: user, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="user.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${user?.passwordExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: user, field: 'username', 'error')} ">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		
	</label>
	<g:textField name="username" value="${user?.username}" />

</div>

