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
                    <spring:message code="test.modify.title" /><%--수정 제목--%>
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body" id="myCommentModalBody" >
                <%--인풋 작성 및 필요 내용 기입--%>
                    <input type="hidden" name="boardNo" value="${readBoardContent.boardNo}">
                    <input type="hidden" name="commentNo" value="">
                    <input type="hidden" name="userId" value="${sessionScope.userInfo.userId}">
                    <textarea maxlength="111" id="myCommentModalTextArea" name="content" cols="63" rows="4" ></textarea>
            </div>
            <div class="modal-footer">
                <button id="commentRegBtn" type="button" class="btn btn-outline-primary" >
                    <spring:message code="test.modify.register"  />
                </button>
                <button id="commentDelBtn" type="button" class="btn btn-outline-danger" >
                    <spring:message code="test.modify.delete"  />
                </button>
                <button id="commentModBtn" type="button" class="btn btn-outline-warning" >
                    <spring:message code="test.modify.modify"  />
                </button>
                <button id="commentCloseBtn" type="button" class="btn btn-light" data-dismiss="modal">
                    <spring:message code="test.modify.close"  />
                </button>
            </div>
        </div>
    </div>
</div>
<%-- end Modal Controll --%>
