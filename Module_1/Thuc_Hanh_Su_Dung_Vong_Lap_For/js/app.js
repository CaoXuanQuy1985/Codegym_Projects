let locBtn, locResult;

window.onload = init();

function init(){
    locBtn = document.getElementById("btn");
    locResult = document.getElementById("result");
}

locBtn.addEventListener("click", function(){
    for(let i = 0; i < 6; i++){
        locResult.innerHTML += "The Number is: " + i + "<br/>";
    }
}, false);