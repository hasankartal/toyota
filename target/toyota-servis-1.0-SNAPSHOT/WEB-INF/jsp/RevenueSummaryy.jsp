<%--
  Created by IntelliJ IDEA.
  User: Hasan
  Date: 7.10.2016
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html>
<body>
<h2>Spring MVC</h2>

<h3>Revenue Report</h3>

<table border="1px" cellpadding="8px">
    <tr>
        <td>Month</td><td>Revenue</td>
    </tr>

    <c:forEach items="${revenueData}" var="current">
        <tr>
            <td><c:out value="${current.key}" /></td>
            <td><c:out value="${current.value}" /></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
