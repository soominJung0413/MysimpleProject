<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-19
  Time: 오전 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset='utf-8'>
  <meta name='viewport' content='width=device-width, initial-scale=1'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>
  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>
  <script src='https://kit.fontawesome.com/a076d05399.js'></script>
  <%-- Slick --%>
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
  <script src='/resources/js/slick.js'></script>
  <link rel="stylesheet" type="text/css" href="/resources/css/slick.css"/>

  <title><spring:message code="navar.main"/> </title>
</head>
<body >


  <div class="container">

  <%@include file="../includes/navar.jsp"%>
    <%-- Slick.js items --%>
    <%@include file="../includes/slick.jsp"%>
    <%-- end Slick.js items --%>



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

            }else if(RegisterResult.startsWith("register")){
              $('#myRegisterModal').find('p').html(' <spring:message code="test.body" > <spring:argument value="${requestScope.Success}" />  </spring:message>');
              var text = $('#myRegisterModal').find('p').html();
              text = text.replace("register","");
              console.log(text)
              $('#myRegisterModal').find('p').empty();
              $('#myRegisterModal').find('p').append(text);
              $('#myRegisterModal').modal('show');
            }else if(RegisterResult.startsWith("logout")){
              $('#myRegisterModal').find('p').html(' <spring:message code="testLogout.body" > <spring:argument value="${requestScope.Success}" />  </spring:message>');
              var text = $('#myRegisterModal').find('p').html();
              text = text.replace("logout","");
              console.log(text)
              $('#myRegisterModal').find('p').empty();
              $('#myRegisterModal').find('p').append(text);
              $('#myRegisterModal').modal('show');
            }else if(RegisterResult.startsWith("Failed")){
              $('#myRegisterModal').find('p').html(' <spring:message code="testLogoutFailed" > <spring:argument value="${requestScope.Success}" />  </spring:message>');
              var text = $('#myRegisterModal').find('p').html();
              text = text.replace("Failed","");
              console.log(text)
              $('#myRegisterModal').find('p').empty();
              $('#myRegisterModal').find('p').append(text);
              $('#myRegisterModal').modal('show');
            }
        }

      }
    </script>
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

    <%-- Content Body --%>

    <div class="row mb-2">
      <div class="col-md-6">
        <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
          <div class="col p-4 d-flex flex-column position-static">
            <strong class="d-inline-block mb-2 text-primary">World</strong>
            <h3 class="mb-0">Featured post</h3>
            <div class="mb-1 text-muted">Nov 12</div>
            <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
            <a href="#" class="stretched-link">Continue reading</a>
          </div>
          <div class="col-auto d-none d-lg-block">
            <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
          <div class="col p-4 d-flex flex-column position-static">
            <strong class="d-inline-block mb-2 text-success">Design</strong>
            <h3 class="mb-0">Post title</h3>
            <div class="mb-1 text-muted">Nov 11</div>
            <p class="mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
            <a href="#" class="stretched-link">Continue reading</a>
          </div>
          <div class="col-auto d-none d-lg-block">
            <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
          </div>
        </div>
      </div>
    </div>
  </div>

  <main role="main" class="container">
    <div class="row">
      <div class="col-md-8 blog-main">
        <h3 class="pb-4 mb-4 font-italic border-bottom">
          글 목록
        </h3>

        <div class="blog-post">
          <h2 class="blog-post-title">최신글</h2>
          <p class="blog-post-meta">날짜 by <a href="#">작성자</a></p>
            <p>글내용</p>
        </div><!-- /.blog-post -->


          <%--페이지 네이션, 처리필요--%>
        <nav class="blog-pagination">
          <a class="btn btn-outline-primary" href="#">Older</a>
          <a class="btn btn-outline-secondary disabled" href="#" tabindex="-1" aria-disabled="true">Newer</a>
        </nav>

      </div><!-- /.blog-main -->

      <%--asidebar--%>
      <%@include file="/WEB-INF/includes/aside.jsp"%>
      <!-- end asidebar -->

    </div><!-- /.row -->

  </main><!-- /.container -->

  <%-- end ContentBody --%>


  
  <%@include file="../includes/footer.jsp"%>

  </div>
</body>
</html>

