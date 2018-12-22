<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sotels - Hotel</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
</head>
<body>
    <div class="container">
        <div class="h2"><c:out value="${hotel.name}"/></div>
        <div>
            <span class="label label-info"><c:out value="${hotel.address}"/></span>
            <span class="label label-danger"><c:out value="${hotel.rating}"/></span>
        </div>
    </div>
</body>
</html>
