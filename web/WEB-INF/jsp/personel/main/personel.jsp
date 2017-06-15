<%--
  Created by IntelliJ IDEA.
  User: Hasan
  Date: 26.08.2016
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<c:url var="actionURL" value="/personel.get"/>
<form:form modelAttribute="newRoute" class="form-horizontal" method="post" action="${actionURL}">
    <%--<form:errors path="*" cssClass="errorblock" element="div" />--%>
    <table>

        <form:select path="id">
            <%--<td>Please select :</td>--%>
            <option value="Select" label="Select a card type"></option>
            <form:options items="${citiesMap}" />
        </form:select>

        <%--<form:select path="id">--%>
            <%--<td>Please select 2</td>--%>
            <%--<option value="Select" label="Select a card type"></option>--%>
            <%--<form:options items="${citiesMap}" />--%>
        <%--</form:select>--%>
        <tr>
            <td colspan="3"><input type="submit"  value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
