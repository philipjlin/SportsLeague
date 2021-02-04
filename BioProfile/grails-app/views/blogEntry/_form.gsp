<%@ page import="league.BlogEntry" %>



<div class="fieldcontain ${hasErrors(bean: blogEntry, field: 'comments', 'error')} ">
	<label for="comments">
		<g:message code="blogEntry.comments.label" default="Comments" />
		
	</label>
	<g:select name="comments" from="${league.Comment.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${blogEntry?.comments*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: blogEntry, field: 'datePublished', 'error')} ">
	<label for="datePublished">
		<g:message code="blogEntry.datePublished.label" default="Date Published" />
		
	</label>
	<g:datePicker name="datePublished" precision="day" value="${blogEntry?.datePublished}" />

</div>

<div class="fieldcontain ${hasErrors(bean: blogEntry, field: 'published', 'error')} ">
	<label for="published">
		<g:message code="blogEntry.published.label" default="Published" />
		
	</label>
	<g:checkBox name="published" value="${blogEntry?.published}" />

</div>

<div class="fieldcontain ${hasErrors(bean: blogEntry, field: 'text', 'error')} ">
	<label for="text">
		<g:message code="blogEntry.text.label" default="Text" />
		
	</label>
	<g:textField name="text" value="${blogEntry?.text}" />

</div>

