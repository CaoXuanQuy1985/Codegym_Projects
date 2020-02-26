let locNewElem, locAdd, locArray, locCheck;
let locFindElem, locFind, locResult;
let newArray = [];
let indexFind;

window.onload = init();

function init(){
    locNewElem = document.getElementById("newElem");
    locAdd = document.getElementById("add");
    locArray = document.getElementById("array");
    locFindElem = document.getElementById("findElem");
    locFind = document.getElementById("find");
    locResult = document.getElementById("result");
}

function add(newElem){
    newArray.push(newElem);
    locNewElem.value = "";
    showArray(newArray);
}

function check(elem){
    for(let i = 0; i < newArray.length; i++){
        if(newArray[i] === elem){
            indexFind = i;
            locResult.innerHTML = "Đã tìm thấy phần tử" + elem + " tại vị trí index = [" + indexFind + "]";
            return true;
        }
    }
    locResult.innerHTML = "Phần tử " + elem + " không tồn tại trong mảng";
    return false;
}

function showArray(array){
    let result = "[";
    for(let i = 0; i < array.length; i++){
        result += (i < (array.length - 1)) ? array[i] + ", " : array[i];
    }
    result += "]";
    locArray.innerHTML = result;
}

locAdd.addEventListener("click", function(){
    add(locNewElem.value)
}, false);

locFind.addEventListener("click", function(){
    check(locFindElem.value)
});