let locGenerate9_1, locGenerate9_2, locArray9_1, locArray9_2, locConcat, locResult9;
let newArray9_1, newArray9_2, arrayConcated;

function include9(file) {

    let script  = document.createElement('script');
    script.src  = file;
    script.type = 'text/javascript';
    script.defer = true;

    document.getElementsByTagName('head').item(0).appendChild(script);

}

window.onload = init();

function init(){
    include9("js/bai_tap_1.js");
    include9("js/bai_tap_6.js");
    locGenerate9_1 = document.getElementById("generate9_1");
    locGenerate9_2 = document.getElementById("generate9_2");
    locArray9_1 = document.getElementById("array9_1");
    locArray9_2 = document.getElementById("array9_2");
    locResult9 = document.getElementById("result9");
    locConcat = document.getElementById("concat");
    newArray9_1 = [];
    newArray9_2 = [];
    arrayConcated = [];
}

function concatArray(array1, array2){
    array1.forEach(function(elem){
        arrayConcated.push(elem);
    });
    array2.forEach(function(elem){
        arrayConcated.push(elem);
    });

    return arrayConcated;
}

locGenerate9_1.addEventListener("click", function(){
    newArray9_1 = createIntArr();
    let array9_1Str = getArrayStr(newArray9_1);
    showArray(array9_1Str, locArray9_1);
}, false);

locGenerate9_2.addEventListener("click", function(){
    newArray9_2 = createIntArr();
    let array9_2Str = getArrayStr(newArray9_2);
    showArray(array9_2Str, locArray9_2);
}, false);

locConcat.addEventListener("click", function(){
    showArray(getArrayStr(concatArray(newArray9_1, newArray9_2)), locResult9)
}, false);

