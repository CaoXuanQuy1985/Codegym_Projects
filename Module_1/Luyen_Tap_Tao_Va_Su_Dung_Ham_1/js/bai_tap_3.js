let locInput1, locInput2, locCheck, locResult;

window.onload = init();

function init(){
    locInput1 = document.getElementById("input1");
    locInput2 = document.getElementById("input2");
    locCheck = document.getElementById("check");
    locResult = document.getElementById("result");
}

function checkParameters(value1, value2){
    let sum = 0;
    if(value1 > value2){
        alert("Tham số thứ 1 > tham số thứ 2");
    }else{
        sum = value1 + value2;
        locResult.innerHTML = "Tổng 2 tham số bạn vừa nhập vào là: " + sum;
    }
}

locCheck.addEventListener("click", function(){
    checkParameters(parseFloat(locInput1.value), parseFloat(locInput2.value))
}, false);