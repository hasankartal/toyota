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
<c:url var="actionURL" value="/denemee.get"/>
<form:form modelAttribute="newPersonel" class="form-horizontal" method="post" action="${actionURL}">
    <%--<form:errors path="*" cssClass="errorblock" element="div" />--%>
    <table>

        <legend>Personel Girişi</legend>

        <div class="">
            <label class="col-md-8 control-label">Şehir</label>
            <div class="col-md-8">
                <form:select path="cityId">
                    <option value="Select" label="Select a card type"></option>
                    <form:options items="${citiesMap}" />
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-8 control-label">Güzergah Tipi</label>
            <div class="col-md-8">
                <form:select path="routeTypeId">
                    <option value="Select" label="Select a card type"></option>
                    <form:options items="${routeTypesMap}" />
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label">Güzergah</label>
            <div class="col-md-4">
                <form:select path="id">
                    <option value="Select" label="Select a card type"></option>
                    <form:options items="${routeTypesMap}" />
                </form:select>
            </div>
        </div>

        <tr>
            <td colspan="3"><input type="submit"  value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
