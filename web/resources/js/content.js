$(function(){
    var mod = $('#mod');
    var rem = $('#rem');

    mod.on('click',function(){/*수정폼 제공*/
        console.log("수정폼 제공");
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
           type:"post",
           url:"/board/delete.json",
           contentType:'application/json;charset=UTF-8',
           data:requestData,
           dataType:"json"
       }).done(function (data) {
           var pageInfo = $('#contentPageDataForm').serialize();
           window.location.replace("/board/get?"+pageInfo);
           alert('삭제가 완료되었습니다.');
       }).fail(function (data) {
           console.log(data);
       });
    });
});