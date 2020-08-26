<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-26
  Time: 오후 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<aside class="col-md-4 blog-sidebar">
    <div class="p-4 mb-3 bg-light rounded">
        <h4 class="font-italic">About</h4>
        <p class="mb-0"><em>
            <spring:message code="main.about" />
        </em></p>
    </div>

    <div class="p-4">
        <h4 class="font-italic">월 별 기록</h4>
        <ol class="list-unstyled mb-0">
            <li><a href="#">년도와 월</a></li>
        </ol>
    </div>

    <div class="p-4">
        <h4 class="font-italic">Elsewhere</h4>
        <ol class="list-unstyled">
            <li><a href="https://github.com/soominJung0413" target="_blank">GitHub</a></li>
            <li><a href="https://doli0413.tistory.com/" target="_blank">Tistory</a></li>
            <li><a href="#top">Back to top</a></li>
        </ol>
    </div>
</aside>
