let locAdd, locArray, locReverse, locOriginal, locreverseArray;
let array = [];

window.onload = init();

function init(){
    locAdd = document.getElementById("add");
    locArray = document.getElementById("arr");
    locReverse = document.getElementById("reverse");
    locOriginal = document.getElementById("originalArray");
    locreverseArray = document.getElementById("reverseArray");
}

function add(newElem){
    array.push(newElem);
    locArray.value = "";
}

function reverse(array){
    showArrayReverse(array);
    let index = 0;
    let newArray = [];
    for(let i = (array.length - 1); i >= 0; i--){
        newArray.push(array[i]);
    }

    showArray(newArray);

    return newArray;
}

function showArray(array){
    let result = "";
    for(let i = 0; i < array.length; i++){
        if(i === (array.length - 1)){
            result += array[i];
        }else {
            result += array[i] + ", ";
        }
    }
    locreverseArray.innerHTML = result;
}

function showArrayReverse(array){
    let result = "";
    for(let i = 0; i < array.length; i++){
        if(i === (array.length - 1)){
            result += array[i];
        }else {
            result += array[i] + ", ";
        }
    }
    locOriginal.innerHTML = result;
}

locAdd.addEventListener("click", function(){
    add(locArray.value)
}, false);
locReverse.addEventListener("click", function(){
    reverse(array)
}, false);