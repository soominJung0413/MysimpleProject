$(function(){
    $('#navBtn1').on('click',function(){
        $(this).attr('class','nav-link active');
        $('#navBtn2').attr('class','nav-link');
        $('#navBtn3').attr('class','nav-link');
    });
    $('#navBtn2').on('click',function(){
        $(this).attr('class','nav-link active');
        $('#navBtn1').attr('class','nav-link');
        $('#navBtn3').attr('class','nav-link');
    });
    $('#navBtn3').on('click',function(){
        $(this).attr('class','nav-link active');
        $('#navBtn2').attr('class','nav-link');
        $('#navBtn1').attr('class','nav-link');
    });
    
    $('#navarOption').on('click',function (event) {
        event.preventDefault();
        var readBoardForm = $('#readBoardForm');
        console.log(readBoardForm.html());
        if(readBoardForm.html() === undefined){
            window.location.href=$('#navarOption').attr('href');
        }else{
            var readBoardForm = $('#readBoardForm');
            var pageNum = readBoardForm.find('#pageNum').val();
            var amount = readBoardForm.find('#amount').val();
            var url = $('#navarOption').attr('href') + "?amount="+amount+"&pageNum="+pageNum;
            window.location.href=url;
        }
    })
});
