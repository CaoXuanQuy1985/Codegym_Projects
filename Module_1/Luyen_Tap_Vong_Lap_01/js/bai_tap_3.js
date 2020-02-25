let locBtn, locResult;
let result;

window.init = init();

function init(){
    locBtn = document.getElementById("gen");
    locResult = document.getElementById("result");
}

function generate(number){
    let first, second, newFib, count = 0;
    let result = "";
    first = 1;
    second = 1;
    result += first + ", " + second + ", ";
    while(count < 18){
        newFib = first + second;
        if(count === 17){
            result += newFib
        }else{
            result += newFib + ", ";
        }
        first = second;
        second = newFib;
        count++;
    }
    return result;
}

locBtn.addEventListener("click", function(){
    result = generate(10);
    locResult.innerHTML = result;
    console.log(result);
}, false);