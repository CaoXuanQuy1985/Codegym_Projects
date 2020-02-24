let locNum, locBtn_2, locResult_2;

window.onload = init();

function init(){
    locNum = document.getElementById("num");
    locBtn_2 = document.getElementById("btn_2");
    locResult_2 = document.getElementById("result_2");
}

function sum(n){
    let sum = 0;
    for(let i = 1; i <= n; ++i){
        sum += i;
    }
    return sum;
}

locBtn_2.addEventListener("click", function(){
    let n = locNum.value;
    locResult_2.innerHTML = "Tổng các số từ 1 đến " + n + " la: " + sum(n);
}, false);