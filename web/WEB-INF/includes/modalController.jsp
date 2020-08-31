<%--
  Created by IntelliJ IDEA.
  User: doli0
  Date: 2020-08-31
  Time: 오후 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"  %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="modal" id="myRegisterModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <spring:message code="test.title" />
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="myRegisterModalBody">
                <p>
                    <spring:message code="test.body" >
                        <spring:argument value="${requestScope.Success}" />
                    </spring:message>
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-light" data-dismiss="modal">
                    <spring:message code="test.close"  />
                </button>
            </div>
        </div>
    </div>
</div>
<%-- end Modal Controll --%>
