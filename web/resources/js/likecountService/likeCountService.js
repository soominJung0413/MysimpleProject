var likeCountService = (function (){

    /**
     *  delete LikeCount
     * @param registerData {boardNo:boardNo, userNo:userNo}
     * @param callback Ajax Success callback
     * @param error Ajax Fail callback
     */
    function processRegister(registerData, callback, error){
        var boardNo = registerData.boardNo;
        var userNo = registerData.userNo;

        $.ajax({
            type:"put",
            url:"/likeCounts/"+boardNo+"/"+userNo,
            contentType:"application/json; charset=utf-8",
            success:function(result, status, xhr){
                callback(result);
            },
            error:function (xhr, status ,err) {
                error(err);
            }
        });
    }

    /**
     *  register LikeCount
     * @param deleteData {boardNo:boardNo, userNo:userNo}
     * @param callback Ajax Success callback
     * @param error Ajax Fail callback
     */
    function processDelete(deleteData,callback, error){
        var boardNo = deleteData.boardNo;
        var userNo = deleteData.userNo;

        $.ajax({
            type:"delete",
            url:"/likeCounts/"+boardNo+"/"+userNo,
            contentType: "application/json; charset=utf-8",
            success:function (result, status, xhr) {
                callback(result);
            },
            error: function (xhr, status, err) {
                error(err);
            }
        });
    }

    return {
        processRegister:processRegister,
        processDelete:processDelete
            };

})();