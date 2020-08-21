<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-21
  Time: 오전 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h5 class="my-0 mr-md-auto font-weight-normal"><spring:message code="navar.me" /></h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="${context}/"><spring:message code="navar.main" /></a>
            <a class="p-2 text-dark" href="#"><spring:message code="naver.login" /></a>
            <a class="p-2 text-dark" href="#">default</a>
            <a class="p-2 text-dark" href="#">Pricing</a>
        </nav>
        <a class="btn btn-sm btn-outline-dark" href="${context}/user/create"><spring:message code="navar.register" /></a>

    </div>
</header>
