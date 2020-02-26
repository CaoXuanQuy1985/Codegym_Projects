let locElem, locAdd, locArray, locFindMax, locMax;
let arrayObj;

window.onload = init();

function init(){
    locElem = document.getElementById("elem");
    locAdd = document.getElementById("add");
    locArray = document.getElementById("array");
    locFindMax = document.getElementById("findMax");
    locMax = document.getElementById("max");
    arrayObj = [];
}

function add(newElem){
    if(Number.isNaN(parseFloat(newElem))){
        alert("Hãy nhập vào số nguyên hoặc thập phan");
        return;
    }
    arrayObj.push(newElem);
    locElem.value = "";
    displayArray(arrayObj);
}

function displayArray(array){
    let result = "[";
    for(let element of array){

        result += (array.indexOf(element) !== array.length - 1) ? element + ", " : element;
    }
    result += "]";

    locArray.innerHTML = result;
}

locAdd.addEventListener("click", function(){
    add(locElem.value)
}, false);

function findMax(array){
    let max = array[0];
    for(let element of array){
        max = (max < parseFloat(element)) ? element : max;
    }

    locMax.innerHTML = "Phần Tử lớn nhất (max) trong mảng ở trên là: " + max;
}

locFindMax.addEventListener("click", function(){
    findMax(arrayObj)
}, false);

