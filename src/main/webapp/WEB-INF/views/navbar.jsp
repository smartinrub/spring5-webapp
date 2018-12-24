<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>">Sotels</a>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="<c:url value="/"/>">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/hotels"/>">Hotels</a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/user/register"/>">Register</a></li>
        </ul>
    </div>
</nav>
