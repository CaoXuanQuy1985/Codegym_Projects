let locGenerate, locResult, locFindInt, locTotal, locFindBtn;

window.onload = init();

function init(){
    locGenerate = document.getElementById("generate");
    locResult = document.getElementById("result");
    locFindInt = document.getElementById("findInt");
    locTotal = document.getElementById("total");
    locFindBtn = document.getElementById("find");
}

function createIntArr(){
    let arrayInt = [];

    for(let i = 0; i < 10; i++){
        arrayInt.push(Math.floor(Math.random() * 20));
    }

    return arrayInt;
}

function findInt(array) {
    let newArray = [];
    let count = 0;

    for(let index in array){
        if(array[index] >= 10){
            count++;
            newArray.push(array[index]);
        }
    }

    return newArray;
}

function getArrayStr(array){
    let arrayStr = "[";

    for(let index = 0; index < array.length; index++){
        arrayStr += (index !== (array.length - 1)) ? (array[index] + ", ") : array[index];
    }
    arrayStr += "]";

    return arrayStr;
}

function showArrayInt(str){
    locResult.innerHTML = str;
}

function showArrayResult(array){
    let newArray = findInt(array);
    let textNode = document.createTextNode("Tổng số phần tử trong mảng >= 10 là: " + newArray.length);
    locTotal.innerHTML = textNode.textContent;

    locFindInt.innerHTML = "[" + newArray +"]";
}

let arrayInt = createIntArr();

locGenerate.addEventListener("click", function(){
    showArrayInt(getArrayStr(arrayInt))
    }, false);

locFindBtn.addEventListener("click", function(){
    showArrayResult(arrayInt)
}, false);
