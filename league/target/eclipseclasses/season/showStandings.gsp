
<%@ page import="cscie56.ps2.Season" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'season.label', default: 'Season')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>

        <h2> NBA Standings </h2>

        <h4> Western Conference </h4>
        <table>
            <tr> <th>Wins</th> <th>Losses</th> <th>Percentage</th> <th>Home</th> <th>Away</th> <th>L10</th> <th>Streak</th> </tr>
                <g:fieldValue bean="${seasonInstance}" field="c1"/></span>
        </table>


        <h4> Eastern Conference </h4>
        <table>
            <tr> <th>Wins</th> <th>Losses</th> <th>Percentage</th> <th>Home</th> <th>Away</th> <th>L10</th> <th>Streak</th>
            <tr>
            </tr>
        </table>

	</body>
</html>
