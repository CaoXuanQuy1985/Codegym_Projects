$(document).ready(function() {
    $("#newSmartphoneForm").submit(function(event) {
        var producer = $("#producer").val();
        var model = $("#model").val();
        var price = $("#price").val();
        var json = {
            "producer" : producer,
            "model" : model,
            "price" : price
        }

        $.ajax({
            headers: {
                "Accept" : "application/json",
                "Content-Type" : "application/json"
            },
            type : "POST",
            data : JSON.stringify(json),
            url : "/smartphones/createnewPhones",
            success : function(smartphone) {
                var respContent = "";
                respContent += "<span class='success'>Smartphone was created: [";
                respContent += smartphone.producer + " : ";
                respContent += smartphone.model + " : " ;
                respContent += smartphone.price + "]</span>"
                $("#sPhoneFromResponse").html(respContent);
            }
        });
        event.preventDefault();
    })
});