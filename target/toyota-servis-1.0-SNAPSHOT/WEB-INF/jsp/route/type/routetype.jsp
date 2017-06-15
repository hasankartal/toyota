<%--
  Created by IntelliJ IDEA.
  User: Hasan
  Date: 29.08.2016
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Güzergah Tip Tanımlama</title>
    <!-- bootstrap ve jquery icin js ve css ekleme islemi.. -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <c:set var="buttonName" value="Kaydet"/>
    <c:url var="actionURL" value="/route.type.get"/>
    <c:if test="${ !empty update}">
        <%--<c:url var="actionURL" value="/route.type.update"/>--%>
        <c:set var="buttonName" value="Güncelle"/>
    </c:if>
    <c:if test="${ !empty search}">
        <c:url var="actionURL" value="/route.type.search"/>
        <c:set var="buttonName" value="Ara"/>
    </c:if>
</head>

<body>
<div class="container">
    <div class="card card-container">
        <label class="pull-right">SİSTEM YÖNETİCİSİ</label>
        <h:graphicImage id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
        <p id="profile-name" class="profile-name-card"></p>

        <!-- modelAttribute , form data bind  -->
        <!-- newCity ismi ile Controller'daki newCity attribute isminin ayni olduguna dikkat edelim!  -->
        <form:form  modelAttribute="newRouteType" class="form-horizontal" method="post" action="${actionURL}">
            <fieldset>
                <legend>Güzergah Tipi</legend>
                <td>
                    <form:input id="id" path="id" type="hidden" class="form-control input-md"/>
                </td>
                <!-- Text input-->
                <table id="topTable" class="table table-striped table-bordered"
                       cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>Güzergah Tipi</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr>
                        <td>
                            <form:input id="routeTypeName" path="routeTypeName" type="text" class="form-control input-md"/>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <tr>
                    <td>
                        <input type="submit" id="btnAdd" class="btn btn-primary" value ="${buttonName}"/>
                        <a href="/menu.list" class="btn btn-primary" type="button">Geri Dön</a>
                    </td>
                </tr>
            </fieldset>
        </form:form>
    </div>
</div>

<div class="container">
    <div class="card card-container">
        <legend></legend>
        <table id="bottomTable" class="table table-striped table-bordered"
               cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Güzergah Tipi</th>
            </tr>
            </thead>
            <tbody>
            <!-- Kayitlari listeleyelim... -->
            <c:forEach items="${allRouteTypes}" var="routeType">
                <tr>
                    <td><c:out value="${routeType.routeTypeName}" /></td>
                    <td colspan="2">

                        <!-- edit islemi icin RequestParam ekleyelim... -->
                        <a href="route.type.edit?routeTypeId=${routeType.id}"
                           class="btn btn-warning" type="button">Güncelle</a>

                        <!-- Delete islemi icin RequestParam ekleyelim... -->
                        <a href="route.type.delete?routeTypeId=${routeType.id}"
                           class="btn btn-danger" type="button">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div><!-- /card-container -->


<div class="container">
    <div class="card card-container">
        <tr>
            <td>
                <a href="/route.type.searchPage" class="btn btn-warning" type="button">Listeden Sorgula</a>
            </td>
            <td>
                <a href="/route.type.report" class="btn btn-danger" type="button">Yazıcıya Gönder</a>
            </td>
        </tr>
    </div>
</div>
</body>
</html>