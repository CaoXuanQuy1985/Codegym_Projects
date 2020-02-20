let $ball = $("#ball");
let oldPos, newPos;

init();

function init(){
    $ball[0].style.position = "relative";
    $ball[0].style.left = "0px";
    oldPos = newPos = 0;
}

function moveRight() {
    oldPos = newPos;
    $ball[0].style.left = parseInt(oldPos, 10) + 100 + "px";
    newPos = $ball[0].style.left;
}

function moveLeft(){
    oldPos = newPos;
    $ball[0].style.left = parseInt(oldPos, 10) - 100 + "px";
    newPos = $ball[0].style.left;
}

document.getElementById("left").addEventListener("click", moveLeft, false);
document.getElementById("right").addEventListener("click", moveRight, false);