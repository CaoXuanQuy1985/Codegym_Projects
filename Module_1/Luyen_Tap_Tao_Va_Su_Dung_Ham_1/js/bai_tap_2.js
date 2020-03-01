let locInput, locBtn, locResult;

window.onload = init();

function init(){
    locInput = document.getElementById("inputValue");
    locBtn = document.getElementById("increase");
    locResult = document.getElementById("result");
}

function increase(numberObj){
    numberObj.valueObj = numberObj.valueObj + 1;
    return numberObj.valueObj;
}

locBtn.addEventListener("click", function(){
    let numberObj = {valueObj : parseFloat(locInput.value)};
    locResult.innerHTML = "Giá Trị sau khi tăng lên 1 là: " + increase(numberObj);
}, false);