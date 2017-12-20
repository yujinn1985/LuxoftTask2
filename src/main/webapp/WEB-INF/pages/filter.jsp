<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yujinn
  Date: 19.12.2017
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>com.gmail.myyujinn</title>
</head>
<body>
<ol>
    <h1>Statistics per each file with more than 10 lines:</h1>
    <c:forEach items="${lines}" var="line">
        <li>line</li>
        File ID: ${line.myFile.id}<br>
        Line length: ${line.lineLength}<br>
        Longest word: ${line.longestWord}<br>
        Shortest word: ${line.shortestWord}<br>
        Average length: ${line.averagingLength}<br>
        -------------<br>
    </c:forEach>
</ol>
<p><a href="/">Go back to file statistics</a></p>
</body>
</html>
