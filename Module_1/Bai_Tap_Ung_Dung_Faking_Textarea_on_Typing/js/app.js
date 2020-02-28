let locTextArea, arrayStr;
const source = "Cao Xuan Quy Handsome !!!";
let count = 0;

window.onload = init();

function init(){
    locTextArea = document.getElementById("inputText");
    arrayStr = source.split("");
}

function response(e){
    strs = [
        "Xuan Quy handsome!",
        "Xuan Quy dep trai!"
    ];

     t = $('#inputText');
        str = strs[0];
        len = str.length;
        on = false;

    t.keydown(function(e){
        var l = t.val().length%len+1;

        if(e.which == 9){
            str = strs[(on = !on)|0];
            len = str.length;
        }

        t.val(str.substr(0,l));
        e.preventDefault();
    })
}

locTextArea.addEventListener("keypress", response, false);