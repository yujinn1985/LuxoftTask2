<%--
  Created by IntelliJ IDEA.
  User: Yujinn
  Date: 19.12.2017
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>com.gmail.myyujinn</title>
    <style type="text/css">
        body {
            font-family: Georgia, Times, serif;
            color: blue
        }

        li {
            font-family: Arial, Verdana, sans-serif;
            color: indigo
        }
    </style>
</head>
<body>
<ol>
    <h3><strong>Statistics per each line of the file:</strong></h3>
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
