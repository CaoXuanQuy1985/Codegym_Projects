$(document).ready(function(){
    $("#testForm").submit(function(event){
        event.preventDefault();
        let author = $("#author-find").val();
        ajaxFind(author);
    });

    function ajaxFind(author) {
        $.ajax({
            headers: {
                "Accept" : "application/json",
                "Content-Type" : "application/json"
            },
            type : "POST",
            url : "/search",
            success : function(commentList) {
                alert(commentList[0]);
            }
        })
    }
})