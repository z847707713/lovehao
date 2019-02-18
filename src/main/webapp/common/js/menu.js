$(function(){
    var pathname = window.location.pathname;
    $("a").each(function(){
        if($(this).attr('href') == pathname){
           $(this).addClass('active');
           var parentLi = $(this).parent().parents("li");
           if(parentLi != null){
               parentLi.addClass('open');
           }
        }
    });

})