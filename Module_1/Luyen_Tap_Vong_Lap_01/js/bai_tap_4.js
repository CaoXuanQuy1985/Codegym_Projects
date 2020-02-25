let locFib, locResult, result = "";
let num;

window.init = init();

function init(){
    locFib = document.getElementById("fib");
    locResult = document.getElementById("result");
}

function findNum(arrayFib){
    for(let i = 0; i < arrayFib.length; i++){
        if((arrayFib[i] % 5) === 0){
            num = arrayFib[i];
            locResult.innerHTML = num;
            break;
        }
    }
}

function generateFib(){
    let first = 0, second = 1, newFib;
    let count = 0;
    let arrFib = [];

    arrFib.push(first);
    arrFib.push(second);
    while(count < 18){
        newFib = first + second;
        first = second;
        second = newFib;
        arrFib.push(newFib);
        count++;
    }

    for(let i = 0; i < arrFib.length; i++){
        if(i === arrFib.length - 1){
            result += arrFib[i]
        }else {
            result += arrFib[i] + ", ";
        }
    }

    return arrFib;
}

let arrFib = generateFib();

locFib.innerHTML = result;

findNum(arrFib);