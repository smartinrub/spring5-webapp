<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Duplicate - Sotels</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="error-template">
                    <h1>
                        Oops!</h1>
                    <h2>
                        409 Conflic</h2>
                    <div class="error-details">
                        Sorry, an error has occured, This resource already Exists!
                    </div>
                    <div class="error-actions">
                        <a href="<c:url value="/"/> ">Home</a><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
