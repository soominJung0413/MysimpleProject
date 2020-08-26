<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-26
  Time: 오후 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  trimDirectiveWhitespaces="true" pageEncoding="UTF-8"  %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <title><spring:message code="list.title" /></title>

    <%--list.jsp css--%>
    <link rel="stylesheet" href="/resources/css/list.css">
    <%--end list.jsp css--%>
</head>
<body>
    <div class="container" role="main">
    <%@include file="/WEB-INF/includes/navar.jsp"%>

        <div class="row">
        <%--table --%>
            <div class="col-md-8 blog-main">
        <table class="table table-sm table-hover">
            <thead>
            <tr>
                <th scope="col"><spring:message code="list.tableheader.boardNo" /></th><%--boardNo--%>
                <th scope="col"><spring:message code="list.tableheader.boardTitle" /></th><%--boardTitle--%>
                <th scope="col"><spring:message code="list.tableheader.boardCategory" /></th><%--boardcategory--%>
                <th scope="col"><spring:message code="list.tableheader.readCount" /></th><%--readCount--%>
                <th scope="col"><spring:message code="list.tableheader.userId" /></th><%--userId--%>
                <th scope="col"><spring:message code="list.tableheader.boardRegdate" /></th><%--boardregdate--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="board" items="${boardInfoVO}">
            <tr class="boardListRow" onclick="location.href='/board/${board.boardNo}/read'">
                <td>${board.boardNo}</td>
                <td>${board.boardTitle}</td>
                <td>${board.boardCategory}</td>
                <td>${board.readCount}</td>
                <td>${board.userId}</td>
                <td><fmt:formatDate value="${board.regdate}"/></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
            </div>
        <%--end table--%>


        <%--asidebar--%>
        <%@include file="/WEB-INF/includes/aside.jsp"%>
        <!-- end asidebar -->
        </div>

    <%@include file="/WEB-INF/includes/footer.jsp"%>
    </div>
</body>
</html>
