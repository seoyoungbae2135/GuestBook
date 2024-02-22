$(function(){
    $("#content").focus();

    $("#content").on("focus",removeError);
    $("#writer").on("focus", removeError);
    $("#content").on("blur",addError);
    $("#writer").on("blur", addError);
    $("#writer").on("keyup",function(e){
        if(e.keyCode==13){
            $("#wfm").submit();
        }
    })
});
function removeError(){
    var hasError = $(this).next().hasClass("error");
    if( hasError){
        $(this).next().hide();
    }
}
function addError(){
 var hasError = $(this).next().hasClass("error");
 if( hasError && $(this).val()==''){
         $(this).next().show();
     }
}