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
    <script src="/resources/js/list.js"></script>
    <title><spring:message code="list.title" /></title>

<%--list.jsp css--%>
    <link rel="stylesheet" href="/resources/css/list.css">
<%--end list.jsp css--%>
<%--list.js --%>
    <%--end list.js--%>
    <%-- RedirectAttributes Controll --%>
    <script>
        $(function(){
            var RegisterResult = '<c:out value="${requestScope.Success}" />';
            if(RegisterResult !== ''){
                if (!(history.state != null && history.state.modalOver === true)) {
                    checkModal(RegisterResult);
                }
            }

            history.replaceState({modalOver:true},'',null);//<히스토리내서 내용 삭제시킬 수 있어야함
            console.log('메시지여부'+RegisterResult);

        });

        function checkModal(RegisterResult){

            if(!(RegisterResult == '')){
                if(RegisterResult.startsWith("login")){

                    $('#myRegisterModal').find('p').html(' <spring:message code="testLogin.body" > <spring:argument value='${requestScope.Success}' />  </spring:message>');
                    var text = $('#myRegisterModal').find('p').html();
                    text = text.replace("login","");
                    console.log(text)
                    $('#myRegisterModal').find('p').empty();
                    $('#myRegisterModal').find('p').append(text);
                    $('#myRegisterModal').modal('show');

                }else if(RegisterResult.startsWith("Write")){
                    $('#myRegisterModal').find('p').html(' <spring:message code="testWrite.body" > <spring:argument value="${requestScope.Success}" />  </spring:message>');
                    var text = $('#myRegisterModal').find('p').html();
                    text = text.replace("Write","");
                    console.log(text)
                    $('#myRegisterModal').find('p').empty();
                    $('#myRegisterModal').find('p').append(text);
                    $('#myRegisterModal').modal('show');
                }else if(RegisterResult.startsWith("Modify")){
                    $('#myRegisterModal').find('p').html(' <spring:message code="testModify.body" > <spring:argument value="${requestScope.Success}" />  </spring:message>');
                    var text = $('#myRegisterModal').find('p').html();
                    text = text.replace("Modify","");
                    console.log(text)
                    $('#myRegisterModal').find('p').empty();
                    $('#myRegisterModal').find('p').append(text);
                    $('#myRegisterModal').modal('show');
                }
            }

        }
    </script>
</head>
<body>
<%--Modal Controll--%>
<%@include file="/WEB-INF/includes/modalController.jsp"%>
<%-- end Modal Controll --%>

 <%--@elvariable id="criteria" type="me.soomin.board.domain.pagination.Criteria"--%>
 <form:form id="readBoardForm" modelAttribute="criteria" method="get" >
     <form:hidden path="amount"/>
     <form:hidden path="pageNum"/>
 </form:form>
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
            <tr class="boardListRow" >
                <td class="boardListNo">${board.boardNo}</td>
                <td >${board.boardTitle}&nbsp;&nbsp; <b>[${board.replyCount}]</b> </td>
                <td>${board.boardCategory}</td>
                <td>${board.readCount}</td>
                <td>${board.userId}</td>
                <td><fmt:formatDate value="${board.regdate}"/></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
                <!-- Search Form -->
                <div class="row">
                    <div class="col-lg-12">
                        <form:form modelAttribute="criteria" cssClass="d-flex justify-content-center" method="get" action="/board/get" >
                            <form:select path="type" cssClass="custom-select custom-select-sm">
                                <form:option value="N"><spring:message code="list.select.none" /></form:option>
                                <form:option value="T" ><spring:message code="list.select.title"/></form:option>
                                <form:option value="C" ><spring:message code="list.select.content"/></form:option>
                                <form:option value="W" ><spring:message code="list.select.writer"/></form:option>
                                <form:option value="G" ><spring:message code="list.select.category"/></form:option>
                                <form:option value="TC" ><spring:message code="list.select.titleContent"/></form:option>
                                <form:option value="TW" ><spring:message code="list.select.titleWriter"/></form:option>
                                <form:option value="TWC" ><spring:message code="list.select.titleWriterContent"/></form:option>
                            </form:select>
                            <form:input cssClass="form-control form-control-sm" path="keyword"/>
                            <input type="submit" class="btn btn-sm btn-outline-dark"
                                   value="<spring:message code="list.select.submit" />">
                        </form:form>
                    </div>
                </div>
                <%--pagenation--%>
                <%@include file="/WEB-INF/includes/pagenation.jsp"%>
                <%--end pagenation--%>
            </div>

        <%--end table--%>


        <%--asidebar--%>
        <%@include file="/WEB-INF/includes/aside.jsp"%>
        <!-- end asidebar -->
        </div>

    <%@include file="/WEB-INF/includes/footer.jsp"%>
    </div>
<%--PageDataForm--%>

</body>
</html>
