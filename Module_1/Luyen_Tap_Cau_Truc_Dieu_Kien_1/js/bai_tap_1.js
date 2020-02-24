let locA, locB, locBtn_1, locResult;

window.onload = init();

function init(){
    locA = document.getElementById("a");
    locB = document.getElementById("b");
    locBtn_1 = document.getElementById("btn_1");
    locResult = document.getElementById("result_1");
}

function check(a, b){
    if((a % b) === 0){
        locResult.textContent = "a chia het cho b";
    }else{
        locResult.textContent = "a khong chia het cho b";
    }
}

locBtn_1.addEventListener("click", function(){
    check(parseInt(locA.value), parseInt(locB.value));
}, false);