let locBtn, locResult;
let result = "";

window.onload = init();

function init(){
    locBtn = document.getElementById("btn");
    locResult = document.getElementById("result");
}

function count(){
    for(let i = 0; i < 100; ++i){
        if(i === 99){
            alert("Quá trình xử lý đã hoàn thành !!!");
        }
        result += i + ", ";
        locResult.innerHTML = result;
    }
}

locBtn.addEventListener("click", count, false);