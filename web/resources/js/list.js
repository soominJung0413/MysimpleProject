$(function(){
    $('.boardListRow').on('click',function(event){
        /*readBoardForm*/
        var boardNo = $(this).find('.boardListNo');
        var boardUrl = boardNo.html();
        console.log(boardNo.html());

        var readBoardForm = $('#readBoardForm');
        readBoardForm.attr("action", '/board/read/'+boardUrl);
        readBoardForm.submit();
    });
    $('.page-item').on('click',function (event) {
        event.preventDefault();
        var pageNumber = $(this).find('a').attr('href');
        console.log(pageNumber);
        var readBoardForm = $('#readBoardForm');
        readBoardForm.attr('action','/board/get');
        readBoardForm.find('#pageNum').val(pageNumber);
        readBoardForm.submit();
    })
});