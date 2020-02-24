let locBtn_2, locResult;

window.onload = init();

function init(){
    locBtn_2 = document.getElementById("btn");
    locResult = document.getElementById("result_2");
}

function draw(){
    let result = "";
    for(let i = 1; i <= 100; ++i){
        result += "<hr width=\"" + (i * 2) + "\">" ;
    }
    document.write(result);
}

locBtn_2.addEventListener("click", draw, false);