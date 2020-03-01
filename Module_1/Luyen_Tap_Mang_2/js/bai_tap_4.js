let locInputWord, locCountWord, locResult4;

window.onload = init();

function init(){
    locResult4 = document.getElementById("result4");
    locCountWord = document.getElementById("countWord");
    locInputWord = document.getElementById("input-word");
}

function countWord(str){
    let arrayWord = str.split(" ");

    return arrayWord.length;
}

locCountWord.addEventListener("click", function(){
    locResult4.innerHTML = "Tổng số từ có trong chuỗi bạn vừa nhập vào là: " + countWord(locInputWord.value);
}, false);