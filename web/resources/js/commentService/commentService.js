var commentService = (function () {
    /**
     *  getComment List and total count to client
     * @param param boardNo , pageNum Object
     * @param callback Ajax Success callback
     * @param error Ajax Fail callback
     */
    function getList(param,callback,error) {
        var bno = param.bno;
        var pageNum = param.pageNum||1;

        $.getJSON("/replies/boardNo/page/"+bno+"/"+pageNum,function(result,status, xhr){
            if(callback){
                callback(result.count, result.list);
            }
        },function (xhr,status,err) {
            if(error){
                error(err);
            }
        });
    }

    /**
     * Process Comment Register
     * @param reply : {{userId: *, content: *, boardNo: *}} , userId , content, boardNo
     * @param callback : success callback
     * @param error : error callback
     */
    function register(reply,callback,error) {
        console.log(reply);
        $.ajax({
            type:"post",
            url:"/replies/new",
            data:JSON.stringify(reply),
            contentType:"application/json; charset=utf-8",
            success:function (result,status,xhr) {
                if(callback){
                    callback(result);
                }
            },
            error:function (status,xhr,err) {
                if(error){
                    error(err);
                }
            }
        });

    }




    /**
     *  get pattern of Date with today
     * @param timeValue timestamp of regdate
     * @returns {string} convert date String
     */
    function displayTime(timeValue){
        var today= new Date();

        var gap = today.getTime() - timeValue;

        var timeObj = new Date(timeValue);

        var str = "";

        if( gap < (1000 * 60 * 60 *24) ) {
            var hh = timeObj.getHours();
            var mi = timeObj.getMinutes();
            var ss = timeObj.getSeconds();

            return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0')+ mi, ':', (ss > 9 ? '' : '0')+ss ].join('');
        } else {
            var yy = timeObj.getFullYear();
            var mm = timeObj.getMonth() + 1;
            var dd = timeObj.getDate();

            return [ yy, '/', (mm > 9 ? '' : '0')+ mm, '/', (dd > 9 ? '' : '0') + dd ].join('');
        }

    }

    /**
     * Process Comment Modify
     * @param content : {commentNo: CommentNumber,content:CommentContent}
     * @param callback : success callback
     * @param error : error callback
     */
    function modify(content, callback, error) {//콘텐트 코멘드 넘버가 필요. 코멘드 넘버는 주소, 내용은 vo의 파라미터
        $.ajax({
            type:"put",
            url:"/replies/commentNo/"+content.commentNo,
            data:JSON.stringify(content),
            contentType:"application/json; charset=utf-8",
            success:function (result,status,xhr) {
                if(callback){
                    callback(result);
                }
            },
            error:function (status,xhr,err) {
                if(error){
                    error(err);
                }
            }
        });
    }

    /**
     * Process Comment Remove
     * @param commentNo : commentNo: CommentNumber
     * @param callback : success callback
     * @param error : error callback
     */
    function remove(commentNo,callback,error) {
        $.ajax({
            type:"delete",
            url:"/replies/commentNo/"+commentNo,
            contentType:"application/json; charset=utf-8",
            success:function (result,status,xhr) {
                if(callback){
                    callback(result);
                }
            },
            error:function (status,xhr,err) {
                error(err);
            }
        });
    }
    
    return {
        getList:getList,
        displayTime:displayTime,
        register:register,
        modify:modify,
        remove:remove
    };
})();