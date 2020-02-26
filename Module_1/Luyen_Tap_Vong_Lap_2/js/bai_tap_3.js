let locResult, result = "";

window.onload = init();

function init(){
    locResult = document.getElementById("result");
}

function triangleTopRight(){
    for(let i = 1; i <= 5; i++){
        for(let j = 1; j <= i; ++j){
            result += "*";
        }
        result += "<br/>";
    }
    locResult.innerHTML = result;
}

function triangleBottomRight(){
    for(let i = 5; i >= 1; i--){
        for(let j = i; j >= 1; --j){
            result += "*";
        }
        result += "<br/>";
    }
    locResult.innerHTML = result;
}

function triangleTopLeft(){
    for(let i = 1; i <= 5; i++){
        for(let j = 1; j <= 5; j++){
            if(j <= (5 - i)){
                result += "&nbsp;&nbsp;";
            }else{
                result += "*";
            }
        }
        result += "<br/>";
    }
    locResult.innerHTML = result;
}

function triangleBottomLeft(){
    for(let i = 5; i >= 1; i--){
        for(let j = 1; j <= 5; j++){
            if(j <= 5 - i){
                result += "&nbsp;&nbsp;";
            }else{
                result += "*";
            }
        }
        result += "<br/>";
    }
    locResult.innerHTML = result;
}

function triangleTopRight2(){
    for(let i = 1; i <= 5; i++){
        for(let j = 1; j <= i; ++j){
            result += "*";
        }
        result += "<br/>";
    }
    locResult.innerHTML = result;
}

function triangleBottomRight2(){
    for(let i = 5; i >= 1; i--){
        for(let j = i; j >= 1; --j){
            result += "*";
        }
        result += "<br/>";
    }
    locResult.innerHTML = result;
}

function triangleTopLeft2(){
    for(let i = 1; i <= 5; i++){
        for(let j = 1; j <= 5; j++){
            if(j <= (5 - i)){
                result += "&nbsp;&nbsp;";
            }else{
                result += "*";
            }
        }
        //result += "<br/>";
    }
    locResult.innerHTML = result;
}

function triangleBottomLeft2(){
    for(let i = 5; i >= 1; i--){
        for(let j = 1; j <= 5; j++){
            if(j <= 5 - i){
                result += "&nbsp;&nbsp;";
            }else{
                result += "*";
            }
        }
        //result += "<br/>";
    }
    locResult.innerHTML = result;
}

triangleTopRight();
result += "<br/>";
triangleBottomRight();
result += "<br/>";
triangleTopLeft();
result += "<br/>";
triangleBottomLeft();
result += "<br/>";
result += "<br/>";
result += "<br/>";
