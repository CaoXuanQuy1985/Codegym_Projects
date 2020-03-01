let locGenerate8, locArray8, locSort, locResult8;
let newArrayInt8;

function include8(file) {

    let script  = document.createElement('script');
    script.src  = file;
    script.type = 'text/javascript';
    script.defer = true;

    document.getElementsByTagName('head').item(0).appendChild(script);

}

window.onload = init();

function init(){
    include8("js/bai_tap_1.js");
    include8("js/bai_tap_6.js");
    locGenerate8 = document.getElementById("generate8");
    locArray8 = document.getElementById("array8");
    locResult8 = document.getElementById("result8");
    locSort = document.getElementById("sort");
    newArrayInt8 = [];
}

function sortDecrease(array, loc){
    let newArray = array.sort(function(a, b){
        return b - a;});

    loc.innerHTML = "Mảng sau khi đã được sắp xếp giảm dần: " + newArray;
}

locGenerate8.addEventListener("click", function(){
    newArrayInt8 = createIntArr();
    showArray(getArrayStr(newArrayInt8), locArray8);
}, false);

locSort.addEventListener("click", function(){
    sortDecrease(newArrayInt8, locResult8)
}, false);