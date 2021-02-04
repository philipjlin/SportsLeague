
<%@ page import="league.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>

	<body>
		<a href="#list-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div id="list-person" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

			<div class="container">

				<div class="row">
					<div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
						<g:sortableColumn property="lastName" title="${message(code:'person.name.label', default:'Name')}" />
					</div>
					<div class="col-lg-2 col-md-3 col-sm-6 hidden-xs">
						<g:sortableColumn property="team" title="${message(code:'person.role.label', default:'Team')}" />
					</div>
					<div class="col-lg-2 col-md-3 hidden-sm hidden-xs">
						<g:sortableColumn property="height" title="${message(code:'person.bio.label', default:'Height')}" />
					</div>
					<div class="col-lg-2 col-md-3 hidden-sm hidden-xs">
						<g:sortableColumn property="weight" title="${message(code:'person.birthPlace.label', default:'Weight')}" />
					</div>
					<div class="col-lg-2 hidden-md hidden-sm hidden-xs">
						<g:sortableColumn property="birthDate" title="${message(code:'person.birthDate.label', default:'Birth Date')}" />
					</div>
					<div class="col-lg-2 hidden-md hidden-sm hidden-xs">
						<g:sortableColumn property="universityAttended" title="${message(code:'person.birthDate.label', default:'University')}" />
					</div>
				</div>

				<div class="row">

					<g:each in="${personInstanceList}" status="i" var="personInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

							<div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
								<g:link action="stats" id="${personInstance.id}">${personInstance.firstName} ${personInstance.lastName}</g:link>
							</div>

							<div class="col-lg-2 col-md-3 col-sm-6 hidden-xs">
								${personInstance.team.teamName}
							</div>

							<div class="col-lg-2 col-md-3 hidden-sm hidden-xs">
								${personInstance.height}
							</div>

							<div class="col-lg-2 col-md-3 hidden-sm hidden-xs">
								${personInstance.weight}
							</div>

							<div class="col-lg-2 hidden-md hidden-sm hidden-xs">
								<g:formatDate format="MM-dd-yyyy" date="${personInstance.birthDate}" />
							</div>

							<div class="col-lg-2 hidden-md hidden-sm hidden-xs">
								${personInstance.universityAttended}
							</div>

						</tr>
					</g:each>

				</div>

			</div>

			<div class="pagination">
				<g:paginate total="${personInstanceCount ?: 0}" />
			</div>

		</div>
	</body>
</html>
