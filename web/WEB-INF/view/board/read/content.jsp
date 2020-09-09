<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-26
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <title><spring:message code="read.title"/></title>

    <%--content.jsp css--%>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/content.css'>
    <%--content.js --%>
    <script src="/resources/js/content.js" ></script>
    <script src="/resources/js/commentService/commentService.js"></script>
    <script src="/resources/js/commentService/showList.js"></script>
    <script src="/resources/js/likecountService/likeCountService.js"></script>

    <script>
        $(function(){
            /*boardNo */
            var bnoValue = "<c:out value='${readBoardContent.boardNo}' />";
            /*session userId*/
            var userId = "<c:out value='${sessionScope.userInfo.userId}'/>";
            showList(1,bnoValue,userId);
            /*pageNationClick Event*/
            $("#commentPagination").on("click","li a",function(e) {
                e.preventDefault();
                var pageNum = $(this).attr("href");
                showList(pageNum,bnoValue,userId);
            });

            /*modal register click control*/
                $("#cont").on("click",function () {
                    $("button[id != 'commentCloseBtn']").hide();
                    $("#commentRegBtn").show();
                    $("#myCommentModal").modal('show');
                });
                $("#commentRegBtn").on("click",function () {
                    var boardNo = $("input:hidden[name='boardNo']").val();
                    var userId = $("input:hidden[name='userId']").val();
                    var content = $("textarea[id='myCommentModalTextArea']").val();
                    var reply = {
                            boardNo: boardNo,
                            userId: userId,
                            content: content
                                };
                    commentService.register(reply,function(result){
                        $("textarea[id='myCommentModalTextArea']").val("");
                        $("#myCommentModal").modal('hide');
                        $("#replyCnt").html(result);
                        alert("Success");
                        showList(-1,boardNo,userId);
                    },function (err) {
                        alert(err);
                    });
                });
            /*end modal register click control*/

            /*modal modify click control*/
            $(".commentUL.list-unstyled").on("click",".contMod",function (e) {
                var commentNo = $(this).next().next().val();
                var content = $(this).prev().find(".col-sm.justify-content-sm-end").html();
                var myCommentModal = $("#myCommentModal");
                myCommentModal.find("input:hidden[name='commentNo']").val(commentNo);

                myCommentModal.find("button[id != 'commentCloseBtn']").hide();
                myCommentModal.find("#commentModBtn").show();
                myCommentModal.find("#myCommentModalTextArea").val(content);
                myCommentModal.modal('show');
            });
            $("#commentModBtn").on("click",function (e) {
                var commentNo = $("input:hidden[name='commentNo']").val();
                var content = $("#myCommentModalTextArea").val();

                var reply = {
                    commentNo:commentNo,
                    content:content
                            };
                console.log(reply);
                commentService.modify(reply,function (result) {
                    var pageNum = $(".commentUL.list-unstyled").next().find(".active").find("a").html();
                    // console.log(pageNum);
                    var boardNo = $("input:hidden[name='boardNo']").val();
                    $("textarea[id='myCommentModalTextArea']").val("");
                    $("#myCommentModal").modal('hide');
                    alert(result);
                    showList(pageNum,boardNo,userId);
                },function (err) {
                    alert(err);
                });
            });
            /*end modal modify click control*/

            /*delete modify click control*/
            $(".commentUL.list-unstyled").on("click",".contDel",function (e) {
                var commentNo = $(this).next().val();
                var content = $(this).prev().prev().find(".col-sm.justify-content-sm-end").html();
                // console.log(commentNo+"//"+content);
                var myCommentModal = $("#myCommentModal");
                myCommentModal.find("input:hidden[name='commentNo']").val(commentNo);

                myCommentModal.find("button[id != 'commentCloseBtn']").hide();
                myCommentModal.find("#commentDelBtn").show();
                myCommentModal.find("#myCommentModalTextArea").val(content);
                myCommentModal.find("#myCommentModalTextArea").attr("readonly","readonly");
                myCommentModal.modal('show');
            });
            $("#commentDelBtn").on("click",function (e) {
                var commentNo = $("input:hidden[name='commentNo']").val();
                commentService.remove(commentNo,function (result) {
                    var boardNo = $("input:hidden[name='boardNo']").val();
                    $("textarea[id='myCommentModalTextArea']").val("");
                    $("#myCommentModal").modal('hide');
                    $("#replyCnt").html(result);
                    alert("Success");
                    showList(1,boardNo,userId);
                },function (err) {
                    alert(err);
                });
            });
            /*end delete modify click control*/

            /*like count register click control*/
            $("#likeBox").on("click","#likeBtn",function(e){
                var boardNo = bnoValue;
                var userNo = "<c:out value='${sessionScope.userInfo.userNo}' />";

                var registerData = {boardNo:boardNo,userNo:userNo};

                likeCountService.processRegister(registerData, function(result){
                    alert("<spring:message code="test.register.like" />");
                    $("#likeCountNum").html(result);
                    $("#likeBtn").hide();
                    $("#likeHeart").show();
                    $("#likeHeader").html("<spring:message code='read.like.complete' />");
                },function(error){});
            });

            /*like count delete click control*/
            $("#likeBox").on("click","#likeHeart",function (e) {
                var boardNo = bnoValue;
                var userNo = "<c:out value='${sessionScope.userInfo.userNo}' />";
                console.log("작동"+boardNo+" , "+userNo);

                var deleteData = {boardNo:boardNo,userNo:userNo};

                likeCountService.processDelete(deleteData, function(result){
                    alert("<spring:message code="test.delete.like" />");
                    $("#likeCountNum").html(result);
                    $("#likeBox").find(".card-title").html();
                    $("#likeHeart").hide();
                    $("#likeBtn").show();
                    $("#likeHeader").html("<spring:message code='read.like' />");

                },function(error){});
            });
            /*end like count delete click control*/

            /*like login required button*/
            $("#likeLogin").on("click",function(e){
                location.href="/login";
            });
            /*end like login required button*/
        });
    </script>

</head>
<body>

<%@include file="/WEB-INF/includes/CommentProcessModal.jsp"%>

<div class="container" role="main">
    <%@include file="/WEB-INF/includes/navar.jsp" %>

    <div class="row">

        <%--delete Modal--%>
        <%@include file="/WEB-INF/includes/deleteModal.jsp"%>

        <%--@elvariable id="criteria" type="me.soomin.board.domain.pagination.Criteria"--%>
        <form:form id="contentPageDataForm" modelAttribute="criteria">
            <form:hidden path="type"/>
            <form:hidden path="keyword"/>
            <form:hidden path="amount"/>
            <form:hidden path="pageNum"/>
        </form:form>

        <%--Input Body Content--%>
        <div class="col-md-8 blog-main">

            <div class="blog-post">
                <div class="row ml-2">
                <div class="col-sm">
                    <input type="hidden" name="boardNo" value="${readBoardContent.boardNo}">
                <h2 class="blog-post-title">${readBoardContent.boardTitle}</h2>
                </div>
                <div class="col-sm-2 justify-content-end" id="modAndRem">
                    <sup id="mod">
                    <c:if test="${not empty sessionScope.userInfo and sessionScope.userInfo.userId eq readBoardContent.userId}">
                        <spring:message code="read.modify"/>
                    </c:if>
                    </sup>
                    <sup id="rem">
                    <c:if test="${not empty sessionScope.userInfo and sessionScope.userInfo.userId eq readBoardContent.userId}">
                        <spring:message code="read.remove"/>
                    </c:if>
                    </sup>
                    <sup id="cont">
                        <c:if test="${not empty sessionScope.userInfo}">
                            <spring:message code="read.content"/>
                        </c:if>
                    </sup>
                </div>
                </div>
                <hr>
                <div class="row ml-2 mr-2">
                    <p class="blog-post-meta">
                       <span>
                       <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-hand-index-thumb"
                            fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                           <path fill-rule="evenodd"
                                 d="M6.75 1a.75.75 0 0 0-.75.75V9.5a.5.5 0 0 1-.854.354l-2.41-2.411a.517.517 0 0 0-.809.631l2.512 4.185 1.232 2.465a.5.5 0 0 0 .447.276h6.302a.5.5 0 0 0 .434-.252l1.395-2.442a2.5 2.5 0 0 0 .317-.991l.272-2.715a1 1 0 0 0-.995-1.1H13.5v1a.5.5 0 1 1-1 0V7.154a4.208 4.208 0 0 0-.2-.26c-.187-.222-.368-.383-.486-.43-.124-.05-.392-.063-.708-.039a4.844 4.844 0 0 0-.106.01V8a.5.5 0 1 1-1 0V5.986c0-.167-.073-.272-.15-.314a1.657 1.657 0 0 0-.448-.182c-.179-.035-.5-.04-.816-.027l-.086.004V8a.5.5 0 1 1-1 0V1.75A.75.75 0 0 0 6.75 1zM8.5 4.466V1.75a1.75 1.75 0 1 0-3.5 0v6.543L3.443 6.736A1.517 1.517 0 0 0 1.07 8.588l2.491 4.153 1.215 2.43A1.5 1.5 0 0 0 6.118 16h6.302a1.5 1.5 0 0 0 1.302-.756l1.395-2.441a3.5 3.5 0 0 0 .444-1.389l.272-2.715a2 2 0 0 0-1.99-2.199h-.582a5.114 5.114 0 0 0-.195-.248c-.191-.229-.51-.568-.88-.716-.364-.146-.846-.132-1.158-.108l-.132.012a1.26 1.26 0 0 0-.56-.642 2.634 2.634 0 0 0-.738-.288c-.31-.062-.739-.058-1.05-.046l-.048.002zm2.094 2.025z"/>
                       </svg>
                           Views ${readBoardContent.readCount}
                       </span>

                    <div class="col justify-content-center">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chat-right-text" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M2 1h12a1 1 0 0 1 1 1v11.586l-2-2A2 2 0 0 0 11.586 11H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zm12-1a2 2 0 0 1 2 2v12.793a.5.5 0 0 1-.854.353l-2.853-2.853a1 1 0 0 0-.707-.293H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12z"/>
                            <path fill-rule="evenodd" d="M3 3.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 6a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 6zm0 2.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                        </svg>
                    Replies <span id="replyCnt">${readBoardContent.replyCount}</span>
                    </div>&nbsp;
                        &nbsp;
                    <div class="col justify-content-end">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart" fill="currentColor"
                             xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M8 2.748l-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                        </svg>
                        Likes <span id="likeCountNum">${readBoardContent.likeCount}</span>
                    </div>
                    <span id="contentInfo"><fmt:formatDate
                            value="${readBoardContent.regdate}"/> by <em>${readBoardContent.userId}</em></span>

                    </p>
                </div>
                <p id="content">${readBoardContent.boardContent}</p>
                <%--likes button--%>
                <p>
                       <span>
                            <div id="likeBox" class="card text-center">
                              <div class="card-body">
                                  <c:if test="${not empty sessionScope.userInfo.userId}">
                                      <h6 id="likeHeader" class="card-title"><spring:message code="read.like"/></h6>
                                      <svg id="likeBtn" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart"
                                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M8 2.748l-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                                    </svg>
                                  </c:if>
                                    <c:if test="${empty sessionScope.userInfo.userId}">
                                        <h6 class="card-title"><spring:message code="read.like.login" /></h6>
                                        <svg id="likeLogin" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-earmark-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                          <path d="M4 0h5.5v1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h1V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z"/>
                                          <path d="M9.5 3V0L14 4.5h-3A1.5 1.5 0 0 1 9.5 3z"/>
                                          <path fill-rule="evenodd" d="M8 11a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                          <path d="M8 12c4 0 5 1.755 5 1.755V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1v-.245S4 12 8 12z"/>
                                        </svg>
                                    </c:if>
                                        <svg id="likeHeart" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                          <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                                        </svg>
                               </div>
                            </div>
                       </span>
                </p>
                <%--end likes button--%>
                <hr>
                <%--comments--%>
                <ul class="commentUL list-unstyled">
                </ul>
                <%--end comments--%>
                <%--comments pagination--%>
                <div id="commentPagination" class="row justify-content-center">

                </div>
                <%--end comments pagination--%>
                <hr>
            </div>
            <%--end Input Body Content--%>

        </div>
        <%--asidebar--%>
        <%@include file="/WEB-INF/includes/aside.jsp" %>
        <!-- end asidebar -->

    </div>
    <%@include file="/WEB-INF/includes/footer.jsp" %>
</div>

</body>
</html>
