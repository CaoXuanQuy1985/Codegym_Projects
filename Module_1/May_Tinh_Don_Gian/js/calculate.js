let locArrayBtn;
let locInput;
let BtnObj;

window.onload = init();

function init(){
    locArrayBtn = document.getElementsByClassName("btn");
    locInput = document.getElementById("screen");
    BtnObj = {
        "+" : function(x, y){return x + parseInt(y);},
        "-" : function(x, y){return x - parseInt(y);},
        "x" : function(x, y){return x * parseInt(y);},
        "/" : function(x, y){return x / parseInt(y);}
    }
}

function getValueBtn(){
    locInput.value += this.value;
}

function authorizeInput(str){
    let arrayStr = str.split("");
    let asciiCode;
    for(let i = 0; i < arrayStr.length; ++i){
        asciiCode = arrayStr[i].charCodeAt(0);
        if((asciiCode < 47) || (asciiCode > 57)){
            if((asciiCode !== 43) && (asciiCode !== 45) && (asciiCode !== 120)){
                return false;
            }
        }
    }
    return true;
}

function processNum(str){
    if(!authorizeInput(str)){
        locInput.value = "";
        return false;
    }
    let arrNum = extractNumber(str);
    let arrOper = extractOperator(str);
    let arr = mergeArray(arrNum, arrOper);
    let arrConverted = convertMultiply(arr);
    let sum = 0;
    let operator = "+";
    for(let i = 0; i < arrConverted.length; i++){
        if(Number.isNaN(parseInt(arrConverted[i]))){
            operator = arrConverted[i];
        }else{
            sum = processOperator(operator, sum, arrConverted[i]);
        }
    }
    locInput.value = sum;
}

function processOperator(operator, sum, num){
    sum = BtnObj[operator](sum, num);
    return sum;
}

function mergeArray(arr1, arr2){
    let newArray = [];
    for(let i = 0; i < arr1.length; i++) {
        if(i < arr1.length - 1) {
            newArray.push(arr1[i]);
            newArray.push(arr2[i]);
        }else{
            newArray.push(arr1[i]);
        }
    }

    return newArray;
}

function extractNumber(source) {
    return source.match(/\d+/g);
}

function extractOperator(source){
    return source.match(/\D+/g);
}

for(let index = 0; index < locArrayBtn.length; ++index){
    if(index !== 12 && index !== 14) {
        locArrayBtn[index].addEventListener("click", getValueBtn, false);
    }
}

locArrayBtn[14].addEventListener("click", function(){
    processNum(locInput.value);
}, false);

function convertMultiply(array){
    let valueElem = null, newELem = null;
    let newArray = [], count = 0;
    let arrayResult = [];
    for(let index = 0; index < array.length; ++index){
        valueElem = parseInt(array[index]);
        if(Number.isNaN(valueElem)){
            if((array[index] === 'x') || (array[index] === '/')) {
                if (array[index] === 'x') {
                    newELem = parseFloat(array[index - 1]) * parseFloat(array[index + 1]);
                }
                else{
                    if(parseInt(array[index + 1]) === 0){
                        locInput.value = "Error !!!";
                    }
                    newELem = parseFloat(array[index - 1]) / parseFloat(array[index + 1]);
                }
                array[index - 1] = newELem.toString();
                for (let i = index; i < array.length; ++i) {
                    array[i] = array[i + 2];
                }
            }
        }
    }

    while((count < array.length) && (typeof array[count] !== "undefined")){
        newArray[count] = array[count];
        count++;
    }

    let checkRemain = false;
    for(let j = 0; j < newArray.length; ++j){
        if((newArray[j] === 'x') || (newArray[j] === '/')){
            checkRemain = true;
            break;
        }
    }
    if(checkRemain){
        convertMultiply(newArray);
    }
        let count_1 = 0;
        while((count_1 < newArray.length) && (typeof newArray[count_1] !== "undefined")){
            arrayResult[count_1] = newArray[count_1];
            count_1++;
        }
    return arrayResult;
}

function reset(){
    locInput.value = "";
}

locArrayBtn[12].addEventListener("click", reset, false);