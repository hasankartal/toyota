<%--
  Created by IntelliJ IDEA.
  User: Hasan
  Date: 29.08.2016
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menü</title>
    <!-- bootstrap ve jquery icin js ve css ekleme islemi.. -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <c:set var="buttonCity" value="Şehir Tanımlama"/>
    <c:set var="buttonRouteType" value="Güzergah Tip Tanımlama"/>
    <c:set var="buttonRoute" value="Güzergah Tanımlama"/>
    <c:url var="actionURL" value="/menu.get"/>
</head>

<body>
<div class="container">
    <div class="card card-container">
        <label class="pull-right">SİSTEM YÖNETİCİSİ</label>
        <legend>Personel Servisleri</legend>
        <h:graphicImage id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
        <p id="profile-name" class="profile-name-card"></p>

        <fieldset>
            <!-- edit islemi icin RequestParam ekleyelim... -->
            <a href="/city.list" class="btn btn-warning btn-block" type="button">Şehir Tanımlama</a>
            <a href="/route.type.list" class="btn btn-warning btn-block" type="button">Güzergah Tip Tanımlama</a>
            <a href="/route.list" class="btn btn-warning btn-block" type="button">Güzergah Tanımlama</a>
            <a href="/station.list" class="btn btn-warning btn-block" type="button">Durak Tanımlama</a>
            <a href="/report" class="btn btn-warning btn-block" type="button">Excel'e Veri Aktar</a>
            <a href="/city.list" class="btn btn-warning btn-block" type="button">Sistem Yönetici Modundan Çıkış</a>
        </fieldset>
    </div>
</div>
</body>
</html>