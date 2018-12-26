<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register Form - Sotels</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="jumbotron" style="margin-bottom:0;">
        <h1>Sign Up</h1>
    </div>
    <c:import url="/WEB-INF/views/navbar.jsp"/>
    <form action="<c:url value="/user/register"/>" method="POST"
          class="needs-validation card p-4"
          novalidate>
        <%-- Allow Cross Site Requests --%>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="firstName" placeholder="First name" name="firstName"
                       required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="lastName" placeholder="Last name" name="lastName" required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="email">Email</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                    </div>
                    <input type="email" class="form-control" id="email" placeholder="email" name="email"
                           aria-describedby="inputGroupPrepend" required>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="password">Password</label>
                <input type="text" class="form-control" id="password" placeholder="Password" name="password" required>
            </div>
            <%--<div class="col-md-6 mb-3">--%>
            <%--<label for="password">Profile Picture</label>--%>
            <%--<div class="custom-file">--%>
            <%--<input type="file" class="custom-file-input" id="profilePicture" name="profilePicture"--%>
            <%--accept="image/jpeg,image/png,image/gif">--%>
            <%--<label class="custom-file-label" for="profilePicture">Choose Profile Picture</label>--%>
            <%--</div>--%>
            <%--</div>--%>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
