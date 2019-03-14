<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="head.jsp"%>

<html>
<body>

<div class="container">
    <h2>Search Results: </h2>

    <c:choose>
    <c:when test="${not empty users}">
        <p>Your search returned ${users.size()} result(s)</p>
        <table class="table table-striped">
            <thead><tr>
                <th>First Name</th><th>Last Name</th><th>User Name</th><th>ID</th><th>D.O.B.</th><th>Age</th><th>Orders</th>
            </tr></thead>
            <tbody>
            <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.email}</td>
                <td>${user.genres}</td>
                <%--<td><c:forEach items="${user.orders}" var="order">--%>
                    <%--${order.id} ${order.description}<br />--%>
            </c:forEach></td>
            </tr>
            </tbody>
        </table>
    </c:when>
    <c:otherwise><p>Sorry, no results were found.</p></c:otherwise>
    </c:choose>
</div>

</body>
</html>
