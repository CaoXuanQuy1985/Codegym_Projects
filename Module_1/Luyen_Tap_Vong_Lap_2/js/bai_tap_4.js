let locResult, result = "";

window.onload = init();

function init(){
    locResult = document.getElementById("result");
}

for(let i = 1; i <= 13; ++i){
    if((i % 2) !== 0){
        if((i === 1) || (i === 13)){
            for(let j = 1; j <= 30; ++j){
                result += "*";
            }
            result += "<br/>";
        }else{
            result += "*";
            for(let j = 1; j <= 25; ++j){
                result += "&nbsp;&nbsp;";
            }
            result += "*";
            result += "<br/>";
        }
    }else{
        continue;
    }
}

locResult.innerHTML = result;
