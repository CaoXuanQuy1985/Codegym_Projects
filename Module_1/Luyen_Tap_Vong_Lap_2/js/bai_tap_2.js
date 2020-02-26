let locNum, locBtn, locResult;

window.onload = init();

function init(){
    locNum = document.getElementById("number");
    locBtn = document.getElementById("cal");
    locResult = document.getElementById("result");
}

function calculate(number){
    let result = 1;
    if(number < 0){
        alert("Bạn đã nhập số nguyên âm, hãy nhập lại số nguyên dương");
        result = "Error";
    }else if(number === 0){
        result = 1;
    }else{
        for(let i = 1; i <= number; i++){
            result *= i;
        }
    }

    return result;
}

locBtn.addEventListener("click", function(){
    locResult.innerHTML = calculate(parseInt(locNum.value));
}, false);