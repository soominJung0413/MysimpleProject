<%--
  Created by IntelliJ IDEA.
  User: doli0
  Date: 2020-08-30
  Time: 오전 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Pagenation -->
<div class="pull-right">
    <ul class="pagination justify-content-center pagination-sm">
        <c:if test="${pageInfo.prev}">
            <li class="page-item"><a class="page-link" href="${pageInfo.startPage - 1}">Previous</a></li>
        </c:if>

        <c:forEach var="num"  begin="${pageInfo.startPage}" end="${pageInfo.endPage}" >
            <li class="page-item ${pageInfo.criteria.pageNum == num ? "active" : "" }">
                <a class="page-link" href="${num}">${num }</a>
            </li>
        </c:forEach>

        <c:if test="${pageInfo.next}">
            <li class="page-item"><a class="page-link" href="${pageInfo.endPage + 1 }">Next</a></li>
        </c:if>
    </ul>
</div>