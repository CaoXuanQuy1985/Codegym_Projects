let locInputElem, locConvert, locResult;

window.onload = init();

function init(){
    locInputElem = document.getElementById("input-Elem");
    locResult = document.getElementById("result");
    locConvert = document.getElementById("convert");
}

function convertString(str){
    let array = str.split("");
    return array;
}

function convertChar(str){
    let arrayStr = convertString(str);
    let newArrayStr = [];
    arrayStr.forEach(function(element){
        element = checkUpperCase(element) ? element.toLowerCase() : element.toUpperCase();
        newArrayStr.push(element);
    });

    let result = "";
    newArrayStr.forEach(function(element){
        result += element;
    });

    locResult.innerHTML = result;
}

function checkUpperCase(c){
    return c === c.toUpperCase();
}

locConvert.addEventListener("click", function(){
    convertChar(locInputElem.value)
}, false);

