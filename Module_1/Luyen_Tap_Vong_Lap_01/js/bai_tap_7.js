let locResult;

window.onload = init();

function init(){
    locResult = document.getElementById("result");
}

function showNumbers(){
    let result = "";
    for(let i = 1; i <= 100; i++){
        if(((i % 3) === 0) && ((i % 5) !== 0)){
            result += "Fizz, ";
        }
        else if(((i % 3) !== 0) && ((i % 5) === 0)){
            result += "Buzz, ";
        }
        else if(((i % 3) === 0) && ((i % 5) === 0)){
            result += "FizzBuzz, ";
        }else {
            result += i + ", ";
        }
    }
    locResult.innerHTML = result;
}

showNumbers();