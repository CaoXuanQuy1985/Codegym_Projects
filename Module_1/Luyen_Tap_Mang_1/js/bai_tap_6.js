let locGenerate6, locArray6, locFindElem6, locResult6, locIndexElem6;
let locInputElem6;
let newArrayInt6, arrayIndexResult6;

function include(file) {

    let script  = document.createElement('script');
    script.src  = file;
    script.type = 'text/javascript';
    script.defer = true;

    document.getElementsByTagName('head').item(0).appendChild(script);

}

window.onload = init();

function init(){
    include("js/bai_tap_1.js");
    locIndexElem6 = document.getElementById("input-Elem");
    locGenerate6 = document.getElementById("generate6");
    locArray6 = document.getElementById("array6");
    locFindElem6 = document.getElementById("findElem6");
    locResult6 = document.getElementById("result6");
    locIndexElem6 = document.getElementById("indexElem");
    locInputElem6 = document.getElementById("input-Elem");
    newArrayInt6 = [];
    arrayIndexResult6 = [];
}

function showArray(arrayStr, loc){
    loc.innerHTML = arrayStr;
}

function findElem(array, elem){
    arrayIndexResult6.length = 0;
    let index = 0;
    array.forEach(function(e){
        if(e === elem){
            arrayIndexResult6.push(index);
        }
        index++;
    });
    return (arrayIndexResult6.length > 0);
}

function showElem(elem){
    let result = "";
    result = findElem(newArrayInt6, elem) ? "Đã tìm thấy phần tử " + elem + " ở trong mảng tại các vị trí sau:" : "Không tìm thấy phần tử " + elem + " ở trong mảng";
    locResult6.innerHTML = result;
    locIndexElem6.innerHTML = arrayIndexResult6;
}

locGenerate6.addEventListener("click", function(){
    newArrayInt6 = createIntArr();
    showArray(getArrayStr(newArrayInt6), locArray6);
}, false);

locFindElem6.addEventListener("click", function(){
    showElem(parseInt(locInputElem6.value))
});



