let locNum1, locNum2, locNum3, locBtn_4, locResult_4;

window.onload = init();

function init(){
    locNum1 = document.getElementById("num1");
    locNum2 = document.getElementById("num2");
    locNum3 = document.getElementById("num3");
    locBtn_4 = document.getElementById("btn_4");
    locResult_4 = document.getElementById("result_4");
}

function check(num1, num2, num3){
    let max = num1;
    if(num1 < num2){
        max = num2;
        if(num2 < num3){
            max = num3;
        }
    }else{
        if(num1 < num3){
            max = num3;
        }
    }
    locResult_4.textContent = "So lon nhat max = " + max;
}

locBtn_4.addEventListener("click", function(){
    check(parseFloat(locNum1.value), parseFloat(locNum2.value), parseFloat(locNum3.value));
}, false);