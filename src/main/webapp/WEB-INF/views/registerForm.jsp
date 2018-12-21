<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register Form - Sotels</title>
    <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet" />
</head>
<body>
    <div class="container">
        <form action="POST">
            <div class="form-group row">
                <label for="first-name-input" class="col-2 col-form-label">First Name</label>
                <div class="col-10">
                    <input class="form-control" type="text" id="first-name-input">
                </div>
            </div>
            <div class="form-group row">
                <label for="last-name-input" class="col-2 col-form-label">Last Name</label>
                <div class="col-10">
                    <input class="form-control" type="text" id="last-name-input">
                </div>
            </div>
            <div class="form-group row">
                <label for="email-input" class="col-2 col-form-label">Email</label>
                <div class="col-10">
                    <input class="form-control" type="email" id="email-input">
                </div>
            </div>
            <div class="form-group row">
                <label for="password-input" class="col-2 col-form-label">Password</label>
                <div class="col-10">
                    <input class="form-control" type="password" id="password-input">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>
