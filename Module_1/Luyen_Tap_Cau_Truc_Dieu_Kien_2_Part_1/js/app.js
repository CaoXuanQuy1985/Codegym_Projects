let locC, locBtn_1, locResult;

window.onload = init();

function init(){
    locC = document.getElementById("c");
    locBtn_1 = document.getElementById("btn_1");
    locResult = document.getElementById("result_1");
}

function check(c){
    let f = (c * (9/5)) + 32;
    locResult.textContent = c + " độ C, chuyển sang thành: " + f + " độ F";
}

locBtn_1.addEventListener("click", function(){
    check(parseInt(locC.value));
}, false);