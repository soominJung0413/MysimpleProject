<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-24
  Time: 오후 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <link rel="stylesheet" href="/resources/css/LoginForm.css">
    <title><spring:message code="login.title"/> </title>
</head>
<body >
<div class="container">
    <%@include file='/WEB-INF/includes/navar.jsp'%>

    <div id="LoginDiv" class="d-flex justify-content-center">
        <%--@elvariable id="loginRequest" type="me.soomin.user.domain.dtd.LoginRequest"--%>
        <form:form action="${context}/login" method="post" modelAttribute="loginRequest">
            <div class="form-group">
                <label for="loginId"><spring:message code="login.id" /></label>
                <form:input required="true" placeholder='Input your Id' cssClass="form-control" id="loginId" aria-describedby="idHelp" path="loginId"/>
                <small id="loginIdHelp" class="form-text text-muted"></small>
                <form:errors path="loginId"  element="small" id="loginIdHelp" cssClass="form-text text-muted" />
            </div>
            <div class="form-group">
                <label for="loginPassword"><spring:message code="login.password" /></label>
                <form:password required="true" placeholder='Input your Password' cssClass="form-control" id="loginPassword" aria-describedby="nameHelp" path="loginPassword"/>
                <small id="loginPasswordHelp" class="form-text text-muted"></small>
                <form:errors path="loginPassword"  element="small" id="loginPasswordHelp" cssClass="form-text text-muted" />
            </div>

            <div class="form-group form-check">
                <form:checkbox path="agreeIdSave" cssClass="form-check-input" id="agreeIdSave" value="false" />
                <label class="form-check-label" for="agreeIdSave"><spring:message code="login.agree" /></label>
                <form:errors path="agreeIdSave"  element="small" id="agreeIdSaveHelp" cssClass="form-text text-muted" />
            </div>
            <input type="submit" class="btn btn-outline-dark" value='<spring:message code='login.submit'/>'/>
            <form:errors  element="small" id="loginRequestHelp" cssClass="form-text text-muted" />
        </form:form>
    </div>
    
    <%@include file="/WEB-INF/includes/footer.jsp"%>
    
</div>
</body>
</html>