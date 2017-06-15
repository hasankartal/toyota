<%--
  Created by IntelliJ IDEA.
  User: Hasan
  Date: 26.08.2016
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Şehir Tanımlama</title>
    <!-- bootstrap ve jquery icin js ve css ekleme islemi.. -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <c:set var="buttonName" value="Kaydet"/>
    <c:set var="buttonSearch" value="Ara"/>
    <c:url var="actionURL" value="/city.get"/>
    <c:if test="${ !empty update}">
        <%--<c:url var="actionURL" value="/city.update"/>--%>
        <c:set var="buttonName" value="Güncelle"/>
    </c:if>
    <c:if test="${ !empty search}">
        <c:url var="actionURL" value="/city.search"/>
        <c:set var="buttonName" value="Ara"/>
    </c:if>
</head>

<body>
<div class="container">
    <div class="card card-container">
        <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
        <h:graphicImage id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
        <p id="profile-name" class="profile-name-card"></p>
        <!-- modelAttribute , form data bind  -->
        <!-- newCity ismi ile Controller'daki newCity attribute isminin ayni olduguna dikkat edelim!  -->
        <form:form  modelAttribute="newCity" class="form-horizontal" method="post" action="${actionURL}">
            <fieldset>
                <legend>Şehir İsmi</legend>
                <td>
                    <form:input id="id" path="id" type="hidden" class="form-control input-md"/>
                </td>
                <!-- Text input-->
                <table id="topTable" class="table table-striped table-bordered"
                       cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>Şehir İsmi</th>
                    </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td>
                                <form:input id="cityName" path="cityName" type="text" class="form-control input-md"/>
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
                <th>Şehir İsmi</th>
            </tr>
            </thead>
            <!-- Kayitlari listeleme... -->
            <tbody>
            <c:forEach items="${allCities}" var="city">
                <tr>
                    <td><c:out value="${city.cityName}" /></td>
                    <td colspan="2">

                        <!-- edit islemi icin RequestParam ekleyelim... -->
                        <a href="city.edit?cityId=${city.id}"
                           class="btn btn-warning" type="button">Güncelle</a>

                        <!-- Delete islemi icin RequestParam ekleyelim... -->
                        <a href="city.delete?cityId=${city.id}"
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
                <a href="/city.searchPage" class="btn btn-warning" type="button">Listeden Sorgula</a>
            </td>
            <td>
                <a href="/city.report" class="btn btn-danger" type="button">Yazıcıya Gönder</a>
            </td>
        </tr>
    </div>
</div>
</body>
</html>
