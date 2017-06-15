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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Güzergah Tanımlama</title>
    <!-- bootstrap ve jquery icin js ve css ekleme islemi.. -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <c:set var="buttonName" value="Kaydet"/>
    <c:url var="actionURL" value="/route.get"/>
    <c:if test="${ !empty update}">
        <%--<c:url var="actionURL" value="/route.update"/>--%>
        <c:set var="buttonName" value="Güncelle"/>
    </c:if>
    <c:if test="${ empty update}">
        <script>
                $(document).ready(function(){
                $("#routeName").val("");
                $("#totalDuration").val("");
                $("#peronNo").val("");
                $("#vehicleType").val("");
            });
        </script>
    </c:if>

    <c:if test="${ !empty search}">
        <script>
            $(document).ready(function(){
//                $("#totalDuration").val("-1");
                $("#peronNo").val("-1");
                $("#vehicleType").val("-1");
            });
        </script>
        <c:url var="actionURL" value="/route.search"/>
        <c:set var="buttonName" value="Ara"/>
    </c:if>
</head>

<body>
<div class="container">
    <div class="card card-container">
        <label class="pull-right">SİSTEM YÖNETİCİSİ</label>
        <h:graphicImage id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
        <p id="profile-name" class="profile-name-card"></p>

        <!-- newRoute ismi ile Controller'daki newRoute attribute isminin ayni olduguna dikkat edelim!  -->
        <form:form  modelAttribute="newRoute" class="form-horizontal" method="post" action="${actionURL}">

        <fieldset>
            <legend>Güzergah</legend>
            <td>
                <form:input id="id" path="id" type="hidden" class="form-control input-md"/>
            </td>
            <table id="topTable" class="table table-striped table-bordered"
                   cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Şehir</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                           <form:select path="cityId" items="${allCities}"></form:select>
                        </td>
                   </tr>
                </tbody>
            </table>

            <table id="topMiddleTable" class="table table-striped table-bordered"
                   cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Güzergah Tipi</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <form:select path="routeTypeId" items="${allRouteTypes}"></form:select>
                    </td>
                </tr>
                </tbody>
            </table>

            <table id="middleTable" class="table table-striped table-bordered"
                   cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Güzergah</th>
                        <th>Güzergah Toplam Süresi</th>
                        <th>Kuzey Otoparkı Peron No</th>
                        <th>Servis Aracı</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <springForm:errors path="routeName" cssClass="error" />
                            <form:input id="routeName" path="routeName" type="text" class="form-control input-md"/>
                        </td>
                        <td>
                            <%--${newRoute.totalDuration}--%>
                            <form:input id="totalDuration" path="totalDuration" type="number"  class="form-control input-md" min="0"/>
                        </td>
                        <td>
                            <form:input id="peronNo" path="peronNo" type="text" class="form-control input-md"/>
                        </td>
                        <td>
                            <form:input id="vehicleType" path="vehicleType" type="text" class="form-control input-md"/>
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
        <legend>Güzergah</legend>

        <table id="bottomTable" class="table table-striped table-bordered"
               cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Şehir</th>
                <th>Güzergah Tipi</th>
                <th>Güzergah</th>
                <th>Toplam Süre</th>
                <th>Peron No</th>
                <th>Servis Aracı</th>
            </tr>
            </thead>

            <tbody>
            <!-- Kayitlari listeleyelim... -->
            <c:forEach items="${allRoutes}" var="route">
                <tr>
                    <td><c:out value="${route.city.cityName}" /></td>
                    <td><c:out value="${route.routeType.routeTypeName}" /></td>
                    <td><c:out value="${route.routeName}" /></td>
                    <td><c:out value="${route.totalDuration}." /></td>
                    <td><c:out value="${route.peronNo}" /></td>
                    <td><c:out value="${route.vehicleType}" /></td>
                    <td colspan="2">
                        <!-- edit islemi icin RequestParam ekleyelim... -->
                        <a href="route.edit?routeId=${route.id}"
                           class="btn btn-warning" type="button">Güncelle</a>
                        <!-- Delete islemi icin RequestParam ekleyelim... -->
                        <a href="route.delete?routeId=${route.id}"
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
                <a href="/route.searchPage" class="btn btn-warning" type="button">Listeden Sorgula</a>
            </td>
            <td>
                <a href="/route.report" class="btn btn-danger" type="button">Yazıcıya Gönder</a>
            </td>
        </tr>
    </div>
</div>
</body>
</html>

