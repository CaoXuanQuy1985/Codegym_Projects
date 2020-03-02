let locResult;

window.onload = init();

function init(){
    locResult = document.getElementById("result");
}

let value = parseFloat(prompt("Hãy Nhập 1 số để tính bình phương:"));

function square(number){
    return number * number;
}

if(value !== null) {
    locResult.innerHTML = "Bình phương của sô: " + value +" là: " + square(value);
}