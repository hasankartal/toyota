<%--
  Created by IntelliJ IDEA.
  User: Hasan
  Date: 25.08.2016
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL ve Spring form tagini ekleylelim.. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Yönetici Girişi</title>

    <!-- bootstrap ve jquery icin js ve css ekleme islemi.. -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<c:url var="actionURL" value="/login.get"/>
<c:set var="buttonName" value="Giriş"/>

<body>
<div class="container">
    <div class="card card-container">
        <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
        <h:graphicImage id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
        <p id="profile-name" class="profile-name-card"></p>
        <!-- modelAttribute , form data bind  -->
        <!-- newPerson ismi ile Controller'daki newPerson attribute isminin ayni olduguna dikkat edelim!  -->
        <form:form  modelAttribute="newEnter" class="form-horizontal" method="post" action="${actionURL}">
            <!-- Form Name -->
            <legend>Yönetici Girişi</legend>
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userName">Kullanıcı Adı</label>
                <div class="col-md-4">
                    <form:input id="userName" path="userName" type="text" class="form-control input-md"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Kullanıcı Şifresi</label>
                <div class="col-md-4">
                    <form:input id="password" path="password" type="text" class="form-control input-md"/>
                </div>
            </div>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="btnAdd"></label>
                <div class="col-md-offset-3">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="${buttonName}"/>
                </div>
            </div>

            </fieldset>
        </form:form>
    </div>
    <div class="col-md-6"></div>
</div>
</fieldset>
</body>
</html>