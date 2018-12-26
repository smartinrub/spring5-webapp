<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User - Sotels</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="jumbotron" style="margin-bottom:0;">
        <h1>User Details</h1>
    </div>
    <c:import url="/WEB-INF/views/navbar.jsp"/>
    <div class="h2"><c:out value="${user.firstName}"/></div>
    <div class="h3"><c:out value="${user.lastName}"/></div>
    <div class="h3"><c:out value="${user.email}"/></div>
</div>
</body>
</html>
