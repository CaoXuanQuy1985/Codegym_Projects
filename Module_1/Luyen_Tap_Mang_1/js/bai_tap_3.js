let locGenerate3, locResult3, locFindMax3, locMax3, locFindAverage, locAverage;
let newArrayInt3;

function include3(file) {

    let script  = document.createElement('script');
    script.src  = file;
    script.type = 'text/javascript';
    script.defer = true;

    document.getElementsByTagName('head').item(0).appendChild(script);

}

window.onload = init();

function init(){
    include3("js/bai_tap_2.js");
    include3("js/bai_tap_1.js");
    locGenerate3 = document.getElementById("generate3");
    locResult3 = document.getElementById("result3");
    locFindMax3 = document.getElementById("findMax3");
    locMax3 = document.getElementById("max3");
    locFindAverage = document.getElementById("findAverage");
    locAverage = document.getElementById("average");
    newArrayInt3 = [];
}

function showArrayInt3(str) {
    locResult3.innerHTML = str;
}

locGenerate3.addEventListener("click", function(){
    newArrayInt3 = createIntArr();
    showArrayInt3(getArrayStr(newArrayInt3))
});

locFindMax3.addEventListener("click", function(){
   showMax(findMax(newArrayInt3), findIndexMax(findMax(newArrayInt3), newArrayInt3), locMax3);
});

function calAverage(array){
    let average, sum = 0;

    array.forEach(function(elem){
        sum += elem;
    })

    average = sum / array.length;

    return average;
}

function showAverage(average){
    locAverage.innerHTML = "Giá trị trung bình của tất cả các phần tử trong mảng la: " + average;
}

locFindAverage.addEventListener("click", function(){
    showAverage(calAverage(newArrayInt3))
}, false);