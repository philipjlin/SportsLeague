<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="result" value="${results}"/>

    <div class="row">

        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-4">
            <div> Team </div>
            <g:each var="result" in="${results}">
                <div>${result.key.teamName}</div>
            </g:each>
        </div>

        <div class="col-lg-1 col-md-2 col-sm-3 col-xs-4">
            <div> Wins </div>
            <g:each var="result" in="${results}">
                <div>${result.value[0]}</div>
            </g:each>
        </div>

        <div class="col-lg-1 col-md-2 col-sm-3 col-xs-4">
            <div> Losses </div>
            <g:each var="result" in="${results}">
                <div>${result.value[1]}</div>
            </g:each>
        </div>

        <div class="col-lg-1 col-md-2 col-sm-3 hidden-xs">
            <div> Percentage </div>
            <g:each var="result" in="${results}">
                <div>${result.value[2]}</div>
            </g:each>
        </div>

        <div class="col-lg-1 col-md-2 hidden-sm hidden-xs">
            <div> Home </div>
            <g:each var="result" in="${results}">
                <div>${result.value[3]}</div>
            </g:each>
        </div>

        <div class="col-lg-1 col-md-2 hidden-sm hidden-xs">
            <div> Away </div>
            <g:each var="result" in="${results}">
                <div>${result.value[4]}</div>
            </g:each>
        </div>

        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div> L10 </div>
            <g:each var="result" in="${results}">
                <div>${result.value[5]}</div>
            </g:each>
        </div>

        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div> Streak </div>
            <g:each var="result" in="${results}">
                <div>${result.value[6]}</div>
            </g:each>
        </div>

    </div>

</div>