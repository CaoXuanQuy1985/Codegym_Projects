let locGenerate4, locResult4, locRevBtn, locRev;
let newArrayInt4;

function include4(file) {

    let script  = document.createElement('script');
    script.src  = file;
    script.type = 'text/javascript';
    script.defer = true;

    document.getElementsByTagName('head').item(0).appendChild(script);

}

window.onload = init();

function init(){
    include4("js/bai_tap_2.js");
    include4("js/bai_tap_1.js");
    locGenerate4 = document.getElementById("generate4");
    locResult4 = document.getElementById("result4");
    locRevBtn = document.getElementById("reverseBtn");
    locRev = document.getElementById("reverse");
    newArrayInt3 = [];
}

function showArrayInt4(str, loc){
    loc.innerHTML = str;
}

function showReverse(array){
    let reverseArr = array.reverse();

    showArrayInt4(getArrayStr(reverseArr), locRev);
}

locGenerate4.addEventListener("click", function(){
    newArrayInt4 = createIntArr();
    showArrayInt4(getArrayStr(newArrayInt4), locResult4)
});

locRevBtn.addEventListener("click", function(){
    showReverse(newArrayInt4)
});
