<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'blogEntry.label', default: 'BlogEntry')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>

		<div id="create-blogEntry" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
		</div>


		<button type="button" class="btn-lg" data-toggle="modal" data-target="#createModal">Create Blog Entry</button>
		<div id="createModal" class="modal" role="dialog">

			<div class="modal-dialog">

				<g:form controller="BlogEntry">

					<label>Create A Blog Post</label>
					<g:textField name="text"/><br/>

					<fieldset class="buttons">
						<g:actionSubmit name="save" value="Save" action="addUnpublishedEntry"/>
						<g:actionSubmit name="publish" value="Publish" action="addPublishedEntry"/>
					</fieldset>
				</g:form>
			</div>
		</div>

	</body>
</html>
