<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sotels - Hotels</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="jumbotron" style="margin-bottom:0;">
        <h1>Hotels</h1>
    </div>
    <c:import url="/WEB-INF/views/navbar.jsp"/>
    <div style="margin-top:1em;">
        <c:forEach items="${hotelList}" var="hotel">
            <div class="card mb-3" style="max-width: 18rem;">
                <h5 class="card-header"><c:out value="${hotel.name}"/></h5>
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${hotel.address}"/></h5>
                    <p class="card-text"><c:out value="${hotel.rating}"/></p>
                    <a href="<c:url value="/hotels/${hotel.id}"/>" class="btn btn-primary">Details</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
