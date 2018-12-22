<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User - Sotels</title>
    <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet" />
</head>
<body>
    <div class="container">
        <div class="h2"><c:out value="${user.firstName}"/></div>
        <div class="h3"><c:out value="${user.lastName}"/></div>
        <div class="h3"><c:out value="${user.email}"/></div>
    </div>
</body>
</html>
