/**
 *  getComment View
 * @param pageNum CommentPageNumber
 * @param bno boardNo
 */
function showList(pageNum,bno,userId){
    console.log("showList method : "+pageNum+" / "+userId);
    commentService.getList({bno:bno,pageNum:pageNum||1},function (count,list) {
        if(pageNum == -1){
            showList(Math.ceil(count/10.0),bno,userId);
            return;
        }
        var str = "";
        var commentUL = $(".commentUL");
        if(list == null || list.length == 0){
            commentUL.html("");
            return ;
        }

        for(var i = 0 , len= list.length; i<len; i++ ){
            str += "<li class=\"media\"> <div class=\"media-body\"><div class=\"col-sm\">" +
                "<svg width=\"1em\" height=\"1em\" viewBox=\"0 0 16 16\" class=\"bi bi-chat-dots\" fill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg\">" +
                "<path fill-rule=\"evenodd\" d=\"M2.678 11.894a1 1 0 0 1 .287.801 10.97 10.97 0 0 1-.398 2c1.395-.323 2.247-.697 2.634-.893a1 1 0 0 1 .71-.074A8.06 8.06 0 0 0 8 14c3.996 0 7-2.807 7-6 0-3.192-3.004-6-7-6S1 4.808 1 8c0 1.468.617 2.83 1.678 3.894zm-.493 3.905a21.682 21.682 0 0 1-.713.129c-.2.032-.352-.176-.273-.362a9.68 9.68 0 0 0 .244-.637l.003-.01c.248-.72.45-1.548.524-2.319C.743 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.52.263-1.639.742-3.468 1.105z\"/>"+
                "<path d=\"M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z\"/>" +
                "</svg>";
            str += "["+list[i].commentNo+"] "+list[i].userId;
            str +="</div><div class=\"col-sm justify-content-sm-end\">"+list[i].content;
            str +="</div></div><div class=\"row mr-2\">"+commentService.displayTime(list[i].regdate);
            // console.log(userId + ", "+list[i].userId);
            str +="</div></li>";
            if(userId == list[i].userId){
                str +="<col><sub class='contMod'>수정</sub>&nbsp;<sub class='contDel'>삭제</sub></col>";
                str += "<input type='hidden' name='commentNo' value='"+list[i].commentNo+"' />";
            }
            str +="<hr/>";
        }

        commentUL.html(str);
        showReplyPage(count,pageNum);
    });
}

/**
 * get Comment Pagination View
 * @param count total Count of comment;
 * @param pageNum CommentPageNumber
 */
function showReplyPage(count,pageNum){

    console.log("showReplyPage :"+count+" / "+pageNum);
    var endNum = Math.ceil(pageNum / 10.0) *10;
    var startNum = endNum - 9;

    var prev = startNum !=  1;
    var next = false;

    if( endNum * 10 >= count ){
        endNum = Math.ceil(count/10.0);
    }
    if( endNum * 10 < count ){
        next = true;
    }

    var str = "<ul class='pagination pull-right' >";
    if (prev) {
        str += "<li class='page-item'><a class='page-link' href='"+(startNum-1)+"'>Previous</a></li>";
    }

    for(var i =startNum ; i<= endNum ; i++){
        var active = pageNum == i ? "active":"";

        str += "<li class='page-item "+active+" '> <a class='page-link' href='"+i+"'>"+i+"</a></li>";
    }

    if(next){
        str += "<li class='page-item'><a class='page-link' href='"+(endNum+1)+"'>Next</a></li> ";
    }

    str += "</ul></div>";

    $('#commentPagination').html(str);
}