let locGenerate2, locResult2, locFindMax, locMax;
let newArrayInt;

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
    locGenerate2 = document.getElementById("generate2");
    locResult2 = document.getElementById("result2");
    locFindMax = document.getElementById("findMax");
    locMax = document.getElementById("max");
    newArrayInt = [];
}

function showArrayInt2(str){
    locResult2.innerHTML = str;
}

function showMax(value, index, location){
    location.innerHTML = "Phần tử có giá trị max là: " + value + " có vị tri index = [" + index + "]";
}

function findMax(array){
    let max = array[0];

    array.forEach((elem, i) => (max = (max < elem) ? elem : max));

    return max;
}

function findIndexMax(value, array){
    return array.indexOf(value);
}

locGenerate2.addEventListener("click", function(){
    newArrayInt = createIntArr();
    showArrayInt2(getArrayStr(newArrayInt))
}, false);

locFindMax.addEventListener("click", function(){
    showMax(findMax(newArrayInt), findIndexMax(findMax(newArrayInt), newArrayInt), locMax)
});


