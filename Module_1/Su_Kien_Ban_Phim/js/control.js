let $img;
let oldPosHorizontal, newPosHorizontal,
    oldPosVertical, newPosVertical;

document.onload = init();

function init(){
    $img = $("#image")[0];
    $img.style.width = "100px";
    $img.style.height = "100px";
    $img.style.position = "relative";
    $img.style.left = "0px";
    $img.style.bottom = "0px";
}

function pressRight(){
    $img.style.left = parseInt(oldPosHorizontal, 10) + 20 + "px";
    newPosHorizontal = $img.style.left;
    oldPosHorizontal = newPosHorizontal;
}

function pressLeft(){
    $img.style.left = parseInt(oldPosHorizontal, 10) - 20 + "px";
    newPosHorizontal = $img.style.left;
    oldPosHorizontal = newPosHorizontal;
}

function pressUp(){
    $img.style.bottom = parseInt(oldPosVertical, 10) + 20 + "px";
    newPosVertical = $img.style.bottom;
    oldPosVertical = newPosVertical;
}

function pressDown(){
    $img.style.bottom = parseInt(oldPosVertical, 10) - 20 + "px";
    newPosVertical = $img.style.bottom;
    oldPosVertical = newPosVertical;
}

//document.onkeydown = checkKey;

/*function checkKey(event) {

    event = event || window.event;

    if (event.keyCode == '38') {
        pressDown();
    }
    else if (event.keyCode == '40') {
        pressUp();
    }
    else if (event.keyCode == '37') {
        pressLeft();
    }
    else if (event.keyCode == '39') {
        pressRight();
    }
}*/

document.onkeydown = function(event){
    event = event || window.event;

    switch(event.keyCode){
        case 38:
            pressUp();
            break;
        case 40:
            pressDown();
            break;
        case 37:
            pressLeft();
            break;
        case 39:
            pressRight();
            break;
        default:
            break;
    }
};

