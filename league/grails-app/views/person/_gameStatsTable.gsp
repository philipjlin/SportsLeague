<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="gameStat" value="${bean}"/>

    <div class="row">
        <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6">
            <div>Game</div>
            <div> ${gameStat.game.awayTeam.teamName} @ ${gameStat.game.homeTeam.teamName} </div>
            <br>
        </div>
        <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6">
            <div>Location</div>
            <div> ${gameStat.game.location} </div>
            <br>
        </div>
        <div class="col-lg-1 col-md-1 col-sm-3 hidden-xs">
            <div>Result</div>
            <div>${gameStat.game.awayPoints}-${gameStat.game.homePoints}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-1 col-sm-3 hidden-xs">
            <div>Mins</div>
            <div>${gameStat.minutesPlayed}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-1 hidden-sm hidden-xs">
            <div>Pnts</div>
            <div>${gameStat.points}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-1 hidden-sm hidden-xs">
            <div>Asts</div>
            <div>${gameStat.assists}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-1 hidden-sm hidden-xs">
            <div>Rebs</div>
            <div>${gameStat.rebounds}</div>
            <br>
        </div>
        <div class="col-lg-1 col-md-1 hidden-sm hidden-xs">
            <div>Stls</div>
            <div>${gameStat.steals}</div>
            <br>
        </div>
        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div>Blks</div>
            <div>${gameStat.blocks}</div>
            <br>
        </div>
        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div>FGM/FGA</div>
            <div>${gameStat.shotsMade}/${gameStat.shotsAttempted}</div>
            <br>
        </div>
        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div>3PM/3PA</div>
            <div>${gameStat.threesMade}/${gameStat.threesAttempted}</div>
            <br>
        </div>
        <div class="col-lg-1 hidden-md hidden-sm hidden-xs">
            <div>PFs</div>
            <div>${gameStat.personalFouls}</div>
            <br>
        </div>
    </div>
</div>