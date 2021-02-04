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

    <table>
        <tr>
            <th>Points</th> <th>Assists</th> <th>Rebounds</th> <th>Steals</th> <th>Blocks</th>
        </tr>

        <tr>
            <g:render template="leaderboardCol" model="[rank:0, ptsRank:ptsRank, astRank:astRank, rebRank:rebRank, stlRank:stlRank, blkRank:blkRank]" />
        </tr>
        <tr>
            <g:render template="leaderboardCol" model="[rank:1, ptsRank:ptsRank, astRank:astRank, rebRank:rebRank, stlRank:stlRank, blkRank:blkRank]" />
        </tr>
        <tr>
            <g:render template="leaderboardCol" model="[rank:2, ptsRank:ptsRank, astRank:astRank, rebRank:rebRank, stlRank:stlRank, blkRank:blkRank]" />
        </tr>
        <tr>
            <g:render template="leaderboardCol" model="[rank:3, ptsRank:ptsRank, astRank:astRank, rebRank:rebRank, stlRank:stlRank, blkRank:blkRank]" />
        </tr>

    </table>

</body>
</html>