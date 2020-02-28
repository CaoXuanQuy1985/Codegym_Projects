let locFah, locBtn, locResult;

window.onload = init();

function init(){
    locFah = document.getElementById("input-Fah");
    locBtn = document.getElementById("btn");
    locResult = document.getElementById("result");
} 

function convert(fah){
    return (fah - 32) / 1.8;
}

function showCelcius(cel){
    locResult.innerHTML = cel;
}

locBtn.addEventListener("click", function(){
    showCelcius(convert((parseFloat(locFah.value))))
}, false);