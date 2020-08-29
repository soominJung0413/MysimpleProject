<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-27
  Time: 오후 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <%--<script src="/resources/js/write.js" />--%>
    <title><spring:message code="write.title"/></title>

<%--css stylesheet--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/write.css">
<%--js--%>
    <script>
        function resize(obj){
            obj.style.height="auto";
            obj.style.height= (12+obj.scrollHeight)+"px";
            obj.setAttribute('placeholder','"Please enter a Content (●\'◡\'●)"');
        }
    </script>
</head>
<body>

<div class="container" role="main">
<%--include navar--%>
    <%@include file="/WEB-INF/includes/navar.jsp"%>

<%--end include navar--%>
    <div class="row">

        <%-- <form:select path="" items="" />--%><%--유저테이블과 연결되는 고유의 카테고리가 존재해야만한다.--%>
        <%--@elvariable id="boardRegisterRequest" type="me.soomin.board.domain.dtd.BoardRegisterRequest"--%>
            <div class="col-md-8 blog-main">
                <div class="blog-post">
            <form:form method="post"
                                   action="${context}/board/${sessionScope.userInfo.userId}/write" modelAttribute="boardRegisterRequest">
                <input type="hidden" value="${sessionScope.userInfo.userId}" />
                    <form:hidden path="criteria.amount"/>
                    <form:hidden path="criteria.pageNum"/>
                            <form:select path="boardCategory" cssClass="custom-select custom-select-sm" cssStyle="width: 20%">
                                <form:option value="NONE"/>
                            </form:select>
                            <form:input path="boardTitle" placeholder='Please enter a title.' required="true" />
                            <form:errors path="boardTitle"/>
                <hr>
                <form:textarea path="boardContent" cols="180" rows="20" placeholder="Please enter a Content (●'◡'●)" onkeyup="resize(this)" onkeydown="resize(this)" />
                <%--onkeyup="resize(this)" onkeydown="resize(this)"--%>
                <input type="submit" class="btn btn-outline-dark" value="<spring:message code="write.submit" />"/>
            </form:form>
                </div>
            </div>

                <%--asidebar--%>
                <%@include file="/WEB-INF/includes/aside.jsp"%>
                <!-- end asidebar -->
    </div>
            <%--include footer--%>
            <%@include file="/WEB-INF/includes/footer.jsp"%>
            <%--end include footer--%>
</div>
</body>
</html>
