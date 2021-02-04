<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div>
    <g:set var="rank" value="${rankList}"/>

    <tr>
        <a href="/league/person/stats/${rank.keySet()[0].id}">${rank.keySet()[0].firstName} ${rank.keySet()[0].lastName}</a> : ${rank.values()[0]}<br>
        <a href="/league/person/stats/${rank.keySet()[1].id}">${rank.keySet()[1].firstName} ${rank.keySet()[1].lastName}</a> : ${rank.values()[1]}<br>
        <a href="/league/person/stats/${rank.keySet()[2].id}">${rank.keySet()[2].firstName} ${rank.keySet()[2].lastName}</a> : ${rank.values()[2]}<br>
        <a href="/league/person/stats/${rank.keySet()[3].id}">${rank.keySet()[3].firstName} ${rank.keySet()[3].lastName}</a> : ${rank.values()[3]}<br>
    </tr>
</div>