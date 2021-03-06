<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-21
  Time: 오전 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/navar.js"></script>
<header>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h5 class="my-0 mr-md-auto font-weight-normal"><spring:message code="navar.me" /> <a href="#top"></a> </h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="${context}/"><spring:message code="navar.main" /></a>
            <c:if test="${empty sessionScope.userInfo}">
            <a class="p-2 text-dark" href="${context}/login"><spring:message code="naver.login" /></a>
            </c:if>
            <a id="navarListGet" class="p-2 text-dark" href="${context}/board/get"><spring:message code="navar.board" /></a>
            <c:if test="${not empty sessionScope.userInfo}">
            <!-- Small button groups (default and split) -->
            <div class="btn-group">
                <a class="p-2 text-dark dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${sessionScope.userInfo.userId}
                </a>
                <div class="dropdown-menu" >
                    <a class="p-2 text-dark" href="${context}/${sessionScope.userInfo.userId}/menu"><spring:message code="navar.mymenu" /></a>
                    <a id="navarOption" class="p-2 text-dark" href="${context}/board/write/${sessionScope.userInfo.userId}"><spring:message code="navar.write" /></a>
                    <br/>
                    <a class="p-2 text-dark" href="${context}/${sessionScope.userInfo.userId}/logout"><spring:message code="navar.logout" /></a>
                </div>
            </div>
            </c:if>
        </nav>
        <a class="btn btn-sm btn-outline-dark" href="${context}/user/create"><spring:message code="navar.register" /></a>
    </div>
</header>
