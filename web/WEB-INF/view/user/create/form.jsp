<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-20
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <link rel='stylesheet' href='/resources/css/RegisterForm.css'>
    <title><spring:message code="register.title" /></title>
    <style>

    </style>

</head>
<body>
    <div class="container">
        <%@include file="/WEB-INF/includes/navar.jsp"%>


        <div id="registerDiv" class="d-flex justify-content-center">
        <%--@elvariable id="userRegisterRequest" type="me.soomin.user.domain.dtd.UserRegisterRequest"--%>
        <form:form action="${context}/user/create" modelAttribute="userRegisterRequest">
            <div class="form-group">
                <label for="userId"><spring:message code="register.id" /></label>
                <form:input required="true" placeholder='Input your Id' cssClass="form-control" id="userId" aria-describedby="idHelp" path="userId"/>
                <small id="emailHelp" class="form-text text-muted"></small>
                    <form:errors path="userId"  element="small" id="IdHelp" cssClass="form-text text-muted" />
            </div>
            <div class="form-group">
                <label for="userName"><spring:message code="register.name" /></label>
                <form:input required="true" placeholder='Input your Name' cssClass="form-control" id="userName" aria-describedby="nameHelp" path="userName"/>
                    <small id="emailHelp" class="form-text text-muted"></small>
                <form:errors path="userName"  element="small" id="nameHelp" cssClass="form-text text-muted" />
            </div>
            <div class="form-group">
                <label for="userPassword"><spring:message code="register.email" /></label>
                <form:password path="userEmail" placeholder="Input your Email" cssClass="form-control"  id="userEmail" required="true"/>
                <form:errors path="userEmail"  element="small" id="EmailHelp" cssClass="form-text text-muted" />
            </div>
            <div class="form-group">
                <label for="userPassword"><spring:message code="register.password" /></label>
                <form:password path="userPassword" placeholder="Input your Password" cssClass="form-control"  id="userPassword" required="true"/>
                <form:errors path="userPassword"  element="small" id="IdHelp" cssClass="form-text text-muted" />
            </div>
            <div class="form-group">
                <label for="userConfirmPassword"><spring:message code="register.confirmPassword" /></label>
                <form:password path="userConfirmPassword" placeholder="Input your ConfirmPassword" cssClass="form-control"  id="userConfirmPassword" required="true"/>
                <form:errors path="userConfirmPassword"  element="small" id="ConfirmPasswordHelp" cssClass="form-text text-muted" />
            </div>
            <div class="form-group form-check">
                <form:checkbox path="agreeCondition" cssClass="form-check-input" id="agreeCondition" value="false" />
                <label class="form-check-label" for="agreeCondition"><spring:message code="register.agree" /></label>
                <form:errors path="agreeCondition"  element="small" id="AgreeHelp" cssClass="form-text text-muted" />
            </div>
            <input type="submit" class="btn btn-outline-dark" value='<spring:message code='register.btn'/>'/>
            <form:errors   element="small" id="ObjectHelp" cssClass="form-text text-muted" />
        </form:form>
        </div>

        <%@include file="/WEB-INF/includes/footer.jsp"%>
    </div>
</body>
</html>
