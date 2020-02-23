let locImage_1, locImage_2, locImage_3, locImage_4;
let listDiv, locPage;
let image_1 = false,
    image_2 = false,
    image_3 = false,
    image_4 = false;
let valueId;

window.onload = init();

function init(){
    locImage_1 = document.getElementById("rectangle_2");
    locImage_2 = document.getElementById("rectangle_3");
    locImage_3 = document.getElementById("rectangle_4");
    locImage_4 = document.getElementById("rectangle_5");
    listDiv = document.getElementsByTagName("div");
    locPage = document.getElementById("page");
}

function random(event){
    event.stopPropagation();
    let min = Math.ceil(1);
    let max = Math.floor(4);
    let random = Math.floor(Math.random() * (max - min + 1)) + min;

    if(random !== 4) {
        this.style.backgroundImage = "url('images/random_images/random_" + random + ".jpg')";
        valueId = this.getAttribute("id");
        if(valueId === "rectangle_2"){
            image_1 = false;
        }
        if(valueId === "rectangle_3"){
            image_2 = false;
        }
        if(valueId === "rectangle_4"){
            image_3 = false;
        }
        if(valueId === "rectangle_5"){
            image_4 = false;
        }
    }else{
        this.style.backgroundImage = null;
        valueId = this.getAttribute("id");
        if(valueId === "rectangle_2"){
            image_1 = true;
        }
        if(valueId === "rectangle_3"){
            image_2 = true;
        }
        if(valueId === "rectangle_4"){
            image_3 = true;
        }
        if(valueId === "rectangle_5"){
            image_4 = true;
        }
    }
    checkOK();
}

function checkOK(){
    if((image_1 === true) && (image_2 === true) && (image_3 === true) && (image_4 === true)){
        locPage.style.border = "10px solid green";
        locImage_1.style.border = "none";
        locImage_2.style.border = "none";
        locImage_3.style.border = "none";
        locImage_4.style.border = "none";
    }
}

for(let i = 0; i < listDiv.length; ++i) {
    listDiv[i].addEventListener("click", random, false);
}