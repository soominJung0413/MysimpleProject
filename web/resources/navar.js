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
});
