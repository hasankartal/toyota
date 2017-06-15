<%--
  Created by IntelliJ IDEA.
  User: Hasan
  Date: 28.09.2016
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Durak Tanımlama</title>

    <!-- bootstrap ve jquery icin js ve css ekleme islemi.. -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <c:set var="buttonName" value="Kaydet"/>
    <c:url var="actionURL" value="/station.get"/>
    <c:if test="${ !empty update}">
        <%--<c:url var="actionURL" value="/station.update"/>--%>
        <c:set var="buttonName" value="Güncelle"/>
    </c:if>

    <c:if test="${ empty update}">
        <script>
            $(document).ready(function(){
                $("#stationNo").val(" ");
            });
        </script>
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
        <form:form  modelAttribute="newStation" class="form-horizontal" method="post" action="${actionURL}">

        <fieldset>
            <legend>Durak</legend>
            <td>
                <form:input id="id" path="id" type="hidden" class="form-control input-md"/>
            </td>
            <table id="topTable" class="table table-striped table-bordered"
                   cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Güzergah</th>
                    <th>
                        <form:select path="routeId" items="${routesMap}"></form:select>
                    </th>
                </tr>
                </thead>
            </table>

            <table id="middleTable" class="table table-striped table-bordered"
                   cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Durak İsmi</th>
                    <th>Durak No</th>
                    <th>Varış Saati(TMMT'den)</th>
                    <th>Kalkış Saati(TMMT'den)</th>
                </tr>
                </thead>
            <br/>
                <tbody>
                <tr>
                    <td>
                        <form:input id="stationName" path="stationName" type="text" class="form-control input-md"/>
                    </td>
                    <td>
                        <form:input id="stationNo" path="stationNo" type="text" class="form-control input-md"/>
                    </td>
                    <td>
                        <form:input id="arrivalTime" path="arrivalTime" type="text" class="form-control input-md"/>
                    </td>
                    <td>
                        <form:input id="departureTime" path="departureTime" type="text" class="form-control input-md"/>
                    </td>
                </tr>
                </tbody>
            </table>

            <tr>
                <td>
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="${buttonName}"/>
                </td>
                <td>
                    <a href="/menu.list" class="btn btn-primary" type="button">Geri Dön</a>
                </td>
            </tr>
         </fieldset>
        </form:form>
    </div>
</div>
<br/>
<br/>

<div class="container">
    <div class="card card-container">

        <table id="bottomTable" class="table table-striped table-bordered"
               cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Şehir</th>
                <th>Güzergah Tipi</th>
                <th>Güzergah</th>
                <th>Durak İsmi</th>
                <th>Durak No</th>
                <th>Varış Saati</th>
                <th>Kalkış Saati</th>
            </tr>
            </thead>

            <tbody>
            <!-- Kayitlari listeleyelim... -->
            <c:forEach items="${allStations}" var="station">
                <tr>
                    <td><c:out value="${station.route.city.cityName}" /></td>
                    <td><c:out value="${station.route.routeType.routeTypeName}" /></td>
                    <td><c:out value="${station.route.routeName}" /></td>
                    <td><c:out value="${station.stationName}" /></td>
                    <td><c:out value="${station.stationNo}" /></td>
                    <td><c:out value="${station.arrivalTime}" /></td>
                    <td><c:out value="${station.departureTime}" /></td>

                    <td colspan="2">
                        <!-- edit islemi icin RequestParam ekleyelim... -->
                        <a href="station.edit?stationId=${station.id}"
                           class="btn btn-warning" type="button">Güncelle</a>
                        <!-- Delete islemi icin RequestParam ekleyelim... -->
                        <a href="station.delete?stationId=${station.id}"
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
                <a href="/station.list" class="btn btn-warning" type="button">Listeden Sorgula</a>
            </td>
            <td>
                <a href="/station.report" class="btn btn-danger" type="button">Yazıcıya Gönder</a>
            </td>
        </tr>
    </div>
</div>
</body>
</html>