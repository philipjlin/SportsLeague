<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="seasonList" value="${seasonList}"/>

    <div class="row">

        <div class="col-lg-1 col-md-2 col-sm-3 col-xs-6">
            <div>Mins</div>
            <div>${seasonList[0]}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-2 col-sm-3 col-xs-6">
            <div>Pnts</div>
            <div>${seasonList[1]}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-2 col-sm-3 hidden-xs">
            <div>Asts</div>
            <div>${seasonList[2]}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-2 col-sm-3 hidden-xs">
            <div>Rebs</div>
            <div>${seasonList[3]}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-2 hidden-sm hidden-xs">
            <div>Stls</div>
            <div>${seasonList[4]}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-2 hidden-sm hidden-xs">
            <div>Blks</div>
            <div>${seasonList[5]}</div>
            <br>
        </div>
        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div>FGM/FGA</div>
            <div>${seasonList[6]}/${seasonList[7]}</div>
            <br>
        </div>
        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div>3PM/3PA</div>
            <div>${seasonList[8]}/${seasonList[9]}</div>
            <br>
        </div>
        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div>PFs</div>
            <div>${seasonList[10]}</div>
            <br>
        </div>
    </div>
</div>