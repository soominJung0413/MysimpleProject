$(function(){
    var mod = $('#mod');
    var rem = $('#rem');

    mod.on('click',function(){/*수정폼 제공*/
        console.log("수정폼 제공");
        var pageInfo = $('#contentPageDataForm').serialize();
        console.log(pageInfo);
        var boardNo = $('input:hidden[name=boardNo]').val();
        window.location.href="/board/modify/"+boardNo+"?"+pageInfo;
    });

    rem.on('click',function(){/*삭제 폼 제공*/
        $('#myDeleteModal').modal('show');
    });

    $('#navarListGet').on('click',function(e){
        e.preventDefault();
        var contentPageDataForm = $('#contentPageDataForm');

        contentPageDataForm.attr("action","/board/get");
        contentPageDataForm.attr("method","get");
        contentPageDataForm.submit();
    });


    $('#myRegisterModalBodySubmit').on('click',function (e) {
        e.preventDefault();

        var userId = $('input:hidden[name=userId]').val();
        var boardNo = $('input:hidden[name=boardNo]').val();

        console.log(userId+","+boardNo);

        var requestObject = {
            userId: userId,
            boardNo: boardNo
        };
        var requestData = JSON.stringify(requestObject);
        console.log(requestData);
       $.ajax({
           type:"delete",
           url:"/board/delete",
           contentType:'application/json;charset=UTF-8',
           data:requestData,
           dataType:"json"
       }).done(function (data) {
           var pageInfo = $('#contentPageDataForm').serialize();
           console.log(data);
           window.location.replace("/board/get?"+pageInfo);
           alert('삭제가 완료되었습니다.');
       }).fail(function (data) {
           console.log(data);
       });
    });
    
    /*댓글 작성*/

});