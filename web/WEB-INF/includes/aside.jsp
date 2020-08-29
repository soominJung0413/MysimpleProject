<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-26
  Time: 오후 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="col" >
    <div class="p-4 mb-3 bg-light rounded">
        <h4 class="font-italic">About</h4>
        <p class="mb-0"><em>
            <spring:message code="main.about" />
        </em></p>
    </div>

    <div class="p-4">
        <h4 class="font-italic"><spring:message code="aside.archive" /></h4>
        <ol class="list-unstyled mb-0">
            <c:forEach var="months" end="12" begin="1">
            <li><a href="#">
                <c:choose>
                    <c:when test="${months == 1}">
                        <spring:message code="aside.record.January" />
                    </c:when>
                    <c:when test="${months == 2}">
                        <spring:message code="aside.record.February" />
                    </c:when>
                    <c:when test="${months == 3}">
                        <spring:message code="aside.record.March" />
                    </c:when>
                    <c:when test="${months == 4}">
                        <spring:message code="aside.record.April" />
                    </c:when>
                    <c:when test="${months == 5}">
                        <spring:message code="aside.record.May" />
                    </c:when>
                    <c:when test="${months == 6}">
                        <spring:message code="aside.record.June" />
                    </c:when>
                    <c:when test="${months == 7}">
                        <spring:message code="aside.record.July" />
                    </c:when>
                    <c:when test="${months == 8}">
                        <spring:message code="aside.record.Aug" />
                    </c:when>
                    <c:when test="${months == 9}">
                        <spring:message code="aside.record.September" />
                    </c:when>
                    <c:when test="${months == 10}">
                        <spring:message code="aside.record.Oct" />
                    </c:when>
                    <c:when test="${months == 11}">
                        <spring:message code="aside.record.November" />
                    </c:when>
                    <c:when test="${months == 12}">
                        <spring:message code="aside.record.Dec" />
                    </c:when>
                </c:choose>
            </a></li>
            </c:forEach>
        </ol>
    </div>

    <div class="p-4">
        <h4 class="font-italic">
            <spring:message code="aside.elsewhere"/>
        </h4>
        <ol class="list-unstyled">
            <li><a href="https://github.com/soominJung0413" target="_blank">GitHub</a></li>
            <li><a href="https://doli0413.tistory.com/" target="_blank">Tistory</a></li>
            <li><a href="#top">Back to top</a></li>
        </ol>
    </div>
</aside>
