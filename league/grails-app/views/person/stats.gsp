
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="league.Person" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'season.label', default: 'Season')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>

    <body>

        <div class="playerpage">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#info">Player Info</a></li>
                <li><a data-toggle="tab" href="#gamelog">Game Log</a></li>
                <li><a data-toggle="tab" href="#seasonstats">Season Stats</a></li>
                <li><a data-toggle="tab" href="#blog">Blog</a></li>
            </ul>

            <div class="tab-content">
                <div id="info" class="tab-pane active">
                    <h2> ${player.firstName} ${player.lastName} </h2>
                    <br>
                    <h4>1. About: ${player.bio} </h4>
                    <h4>2. Team: ${player.team.teamName} </h4>
                    <h4>3. Role: ${player.role} </h4>
                    <h4>4. Height: ${player.height} </h4>
                    <h4>5. Weight: ${player.weight} </h4>
                    <h4>6. Birthplace: ${player.birthPlace} </h4>
                    <h4>7. Birthdate: <g:formatDate format="MM-dd-yyyy" date="${player.birthDate}" /> </h4>
                    <h4>8. University: ${player.universityAttended} </h4>
                </div>

                <div id="gamelog" class="tab-pane fade">
                    <g:each var="gameStat" in="${personGameStatsLog}">
                        <g:render template="gameStatsTable" model="[bean:gameStat]" />
                    </g:each>
                </div>

                <div id="seasonstats" class="tab-pane fade">
                    <h4> Season Totals </h4>
                    <stats:totalStats player="${player}"/>

                    <h4> Season Averages </h4>
                    <stats:averageStats player="${player}"/>
                </div>

                <div id="blog" class="tab-pane fade">
                    <h4> Blog </h4>
                    <g:each var="blogEntry" in="${blogEntries}">

                        <g:if test="${blogEntry.published == true}">

                            <g:render template="blogPost" model="[bean:blogEntry]" />

                            <g:form controller="BlogEntry" params="[entryId:blogEntry.id]">

                                <label>Post A Comment!</label>
                                <g:textField name="text"/><br/>
                                <g:actionSubmit value="Post Comment!" action="addCommentToBlogEntry"/>
                            </g:form>
                        </g:if>
                        <br>
                        <hr>
                    </g:each>
                </div>

            </div>

        </div>

    </body>

</html>