<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Earthquakes | ${year}</title>
</head>
<body>
    <c:if test="${empty earthquakes}">
        No earthquakes in ${ year }
    </c:if>

    <c:if test="${earthquakes.size() > 0}">
        <table>
            <thead>
                <th>#</th>
                <th>ID</th>
                <th>Origin</th>
                <th>Magnitude</th>
                <th>Depth</th>
                <th>Solution</th>
            </thead>
            <tbody>
            <c:forEach var="earthquake" items="${earthquakes}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${earthquake.id}</td>
                    <td>${earthquake.origin}</td>
                    <td>${earthquake.magnitude}</td>
                    <td>${earthquake.depth}</td>
                    <td>${earthquake.solution}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
