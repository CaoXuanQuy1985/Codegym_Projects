let locResult, result = "";

window.onload = init();

function init(){
    locResult = document.getElementById("heart");
}

let step = 0;
let step2 = 1;
for(let i = 1; i <= 22; ++i){
    if((i >= 1) && (i < 5)) {
        for (let j = 1; j <= 61; ++j) {
            if (((j >= 1) && (j <= 6 - step)) || ((j >= 12 + step) && (j <= 20 - step)) || ((j >= 26 + step) && (j <= 61))) {
                result += "&nbsp;&nbsp;";
            } else {
                result += "*";
            }
        }
        result += "<br/>";
        step += 2;
    }
    else if((i >= 5) && (i <= 7)){
        for(let j = 1; j <= 31; j++){
            result += "*";
        }
        result += "<br/>";
    }else {
        for (let j = 1; j <= (31 - step2); j++) {
            if((j >= 1) && (j < step2 + 1)){
                result += "&nbsp;&nbsp;";
            }else {
                result += "*";
            }
        }
        result += "</br>";
        step2 += 1;
    }
}

locResult.innerHTML = result;