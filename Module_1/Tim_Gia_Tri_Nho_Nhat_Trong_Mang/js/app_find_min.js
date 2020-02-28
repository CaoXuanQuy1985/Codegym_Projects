let locInputElem, locAccept, locArray, locFind, locMin, locCreate;
let sourceArray;

window.onload = init();

function init(){
    locInputElem = document.getElementById("input-Elem");
    locAccept = document.getElementById("accept");
    locArray = document.getElementById("array");
    locFind = document.getElementById("find");
    locMin = document.getElementById("min");
    locCreate = document.getElementById("create");
    sourceArray = [];
}

function findMin(array){
    let min = array[0];
    let index;

    for(index in array){
        min = (min > array[index]) ? array[index] : min;
    }

    return min;
}

function showMin(element){
    locMin.innerHTML = element;
}

function showArray(array){
    let result = "[";
    for(let index = 0; index < array.length; index++){
        result += (index === 0) ? array[index] : (", " + array[index]);
    }
    result += "]";

    locArray.innerHTML = result;
}

function addElem(newElem){
    sourceArray.push(newElem);
    showArray(sourceArray);
    locInputElem.value = "";
}

function resetArray(array){
    array.length = 0;
}

function createArray(){
    sourceArray = [];
    showArray(sourceArray);
}

locAccept.addEventListener("click", function(){
    addElem(parseFloat(locInputElem.value))
}, false);

locCreate.addEventListener("click", createArray, false);

locFind.addEventListener("click", function(){
    showMin(findMin(sourceArray))
}, false);