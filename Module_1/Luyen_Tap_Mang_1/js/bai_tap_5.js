let locInputElem, locSource, locCount, locResult;
let numStr;

window.onload = init();

function init(){
    locInputElem = document.getElementById("inputElem");
    locSource = document.getElementById("sourceStr");
    locCount = document.getElementById("countNegative");
    locResult = document.getElementById("result");
}

function getRandomInt(min, max){
    min = Math.ceil(min);
    max = Math.floor(max);
    let test = Math.floor(Math.random() * (max - min)) + min;
    return test;
}

function genStr(lengthStr){
    numStr = "";
    let count = 0;
    let newInt;

    while(count < lengthStr){
        newInt = getRandomInt(-20, 20);
        if(count === lengthStr - 1){
            numStr += newInt;
        }else{
            numStr += newInt + ", ";
        }

        count++;
    }

    return numStr;
}

function showStr(str){
    locSource.innerHTML = str;
}

function countNeg(str){
    let totalNegative = 0;
    let arrayStr = str.split(",");

    arrayStr.forEach(function(element){
        let test = parseInt(element);
        totalNegative = (parseInt(element) < 0) ? (totalNegative + 1) : totalNegative;
    });

    return totalNegative;
}

function showNeg(total){
    locResult.innerHTML = "Tổng số nguyên âm trong chuỗi là: " + total;
}

locInputElem.addEventListener("click", function(){
    showStr(genStr(20))
}, false);

locCount.addEventListener("click", function(){
    showNeg(countNeg(numStr))
}, false);