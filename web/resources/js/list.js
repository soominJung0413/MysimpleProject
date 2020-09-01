$(function(){
    $('.boardListRow').on('click',function(event){
        /*readBoardForm*/
        var boardNo = $(this).find('.boardListNo');
        var boardUrl = boardNo.html();
        console.log(boardNo.html());

        var readBoardForm = $('#readBoardForm');
        readBoardForm.attr("action", '/board/read/'+boardUrl);
            console.log(!($('#type').val() == 'N'));
            if(!($('#type').val() == 'N')){
                var type = $("<input type='hidden' name='type' />");
                type.attr("value",$('#type').val());
                var keyword = $("<input type='hidden' name='keyword' />");
                keyword.attr("value",$('#keyword').val());
                readBoardForm.append(type);
                readBoardForm.append(keyword);
            }
        readBoardForm.submit();
    });
    $('.page-item').on('click',function (event) {
        event.preventDefault();
        var pageNumber = $(this).find('a').attr('href');
        console.log(pageNumber);
        var readBoardForm = $('#readBoardForm');
        readBoardForm.attr('action','/board/get');
        readBoardForm.find('#pageNum').val(pageNumber);
        if(!($('#type').val() == 'N')){
            var type = $("<input type='hidden' name='type' />");
            type.attr("value",$('#type').val());
            var keyword = $("<input type='hidden' name='keyword' />");
            keyword.attr("value",$('#keyword').val());
            readBoardForm.append(type);
            readBoardForm.append(keyword);
        }
        readBoardForm.submit();
    })
});