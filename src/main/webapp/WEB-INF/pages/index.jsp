<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>com.gmail.myyujinn</title>
</head>

<body>
<ol>
    <h1>Statistics per each file:</h1>
    <c:forEach items="${files}" var="file">
        <li>File</li>
        ID ${file.id}<br>
        Total lines ${file.totalLines}<br>
        Total words ${file.totalWords}<br>
    </c:forEach>
</ol>
<h3><em>Please choose the file to view the statistics:</em></h3></p>
<form action="/select" method="GET">
    <input type="radio" name="file" value="1">File One<br>
    <input type="radio" name="file" value="2">File Two<br>
    <input type="radio" name="file" value="3">File Three<br>
    <input type="radio" name="file" value="4">File Four<br>
    <input type="radio" name="file" value="all">View all statistics<br>
    <h3>Apply filter to show files with more than 10 lines:</h3><br>
    <input type="radio" name="filter" value="true">Yes<br>
    <input type="radio" name="filter" value="false">No<br>
    <input type="reset" value="clear all" title="reset"><input type="submit" value="send my form" title="submit">
</form>
</body>
</html>