let locStartMoney, locMonth, locRate;
let locBtn, locResult;

window.onload = init();

function init(){
    locStartMoney = document.getElementById("startMoney");
    locMonth = document.getElementById("month");
    locRate = document.getElementById("rate");
    locBtn = document.getElementById("btn");
    locResult = document.getElementById("result");
}

function calRate(money, month, rate){
    rate = (rate/100).toFixed(3);
    const c = parseFloat("1") + parseFloat(rate);
    let k = 1, tien_lai;

    for(let i = 1; i <= month; ++i){
        k *= c;
    }
    tien_lai = money * (k - 1);

    locResult.innerHTML = "<b>" + tien_lai + "</b>";
}

locBtn.addEventListener("click", function(){
    let money = parseFloat(locStartMoney.value),
        month = parseFloat(locMonth.value),
        rate = parseFloat(locRate.value);
    calRate(money, month, rate)
}, false);

