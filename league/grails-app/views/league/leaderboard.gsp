<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta name="layout" content="main">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
    <title>Leaderboard</title>
</head>

<body>

    <h2> Leaderboard </h2>

    <div class="container">

        <div class="row">

            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div>Points</div>
                <g:render template="leaderboardCol" model="[rankList:ptsRank]" />
                <br>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div>Assists</div>
                <g:render template="leaderboardCol" model="[rankList:astRank]" />
                <br>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div>Rebounds</div>
                <g:render template="leaderboardCol" model="[rankList:rebRank]" />
                <br>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div>Steals</div>
                <g:render template="leaderboardCol" model="[rankList:stlRank]" />
                <br>
            </div>

        </div>
    </div>


</body>
</html>