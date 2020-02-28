let locResult, locBtn;

window.onload = init();

function init(){
    locResult = document.getElementById("result");
    locBtn = document.getElementById("btn");
}

function getInformation(){
    return confirm("Do you want to play the football ?");
}

function responseInformation(answer){
    locResult.innerHTML = (answer) ? "OK we are going to play football now" : "See you again !!!";
}

locBtn.addEventListener("click", function(){
    responseInformation(getInformation())
}, false);