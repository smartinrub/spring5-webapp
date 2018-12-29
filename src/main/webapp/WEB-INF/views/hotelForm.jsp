<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel Form - Sotels</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="jumbotron" style="margin-bottom:0;">
        <h1>Sign Up</h1>
    </div>
    <c:import url="/WEB-INF/views/navbar.jsp"/>
    <form action="<c:url value="/hotels/save"/>" method="POST" class="card p-4" novalidate>
        <%-- Allow Cross Site Requests --%>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" placeholder="Name" name="name" required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" placeholder="Address" name="address" required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="rating">Rating</label>
                <input type="number" class="form-control" id="rating" placeholder="rating" name="rating" required>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
