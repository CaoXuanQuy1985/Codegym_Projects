let locInputElem, locAdd, locArray, locConcat, locResult;
let arrayResult;

window.onload = init();

function init(){
    locInputElem = document.getElementById("input-Elem");
    locAdd = document.getElementById("add");
    locArray = document.getElementById("array");
    locConcat = document.getElementById("concat");
    locResult = document.getElementById("result");
    arrayResult = [];
}

function showArray(array){
    let result = "";
    result += "[";
    array.forEach(function(element){
        result += (array.indexOf(element) !== array.length - 1) ? element + ", " : element;
    });
    result += "]";
    locArray.innerHTML = result;
}

function add(newElem){
    arrayResult.push(newElem);
    locInputElem.value = "";
    showArray(arrayResult);
    concat(arrayResult);
}

function concat(array){
    let result = "\"";
    array.forEach(function(element){
        result += (array.indexOf(element) !== array.length - 1) ? element + ", " : element;
    });
    result += "\"";

    locResult.innerHTML = result;
}

locAdd.addEventListener("click", function(){
    add(locInputElem.value);
}, false);

