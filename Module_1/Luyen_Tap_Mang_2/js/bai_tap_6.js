let locInputStr, locReplace, locResult6;

window.onload = init();

function init(){
    locInputStr = document.getElementById("inputStr");
    locReplace = document.getElementById("replace");
    locResult6 = document.getElementById("result6");
}

function replaceChar(str, char){
    let arrayChar = str.split("");
    let newStr = "";

    for(let i = 0; i < arrayChar.length; i++){
        newStr += (arrayChar[i] === char) ? "_" : arrayChar[i];
    }

    return newStr;
}

locReplace.addEventListener("click", function(){
    let newStr = replaceChar(locInputStr.value, "-");
    locResult6.innerHTML = newStr;
}, false);