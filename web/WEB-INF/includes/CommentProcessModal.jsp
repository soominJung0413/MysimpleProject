<%--
  Created by IntelliJ IDEA.
  User: doli0
  Date: 2020-09-04
  Time: 오후 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="modal" id="myCommentModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <spring:message code="test.delete.title" /><%--삭제 제목 안내--%>
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <p class="mt-5 ml-md-2">
                <spring:message code="test.delete.body" />
            </p>
            <div class="modal-body" id="myDeleteModalBody" >

            </div>
            <div class="modal-footer">
                <input class="btn btn-light" type="submit" value="<spring:message code="test.delete.submit" />"/>
                <button type="button" class="btn btn-light" data-dismiss="modal">
                    <spring:message code="test.close"  />
                </button>
            </div>
        </div>
    </div>
</div>
<%-- end Modal Controll --%>
