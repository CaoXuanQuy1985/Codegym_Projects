let locFib, locResult, result = "";
let sum = 0;

window.init = init();

function init(){
    locFib = document.getElementById("fib");
    locResult = document.getElementById("result");
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
locResult.innerHTML = sumFib(arrFib);

function sumFib(array){
    for(let i = 0; i < (array.length); i++){
        sum += array[i];
    }
     alert(array);
    return sum;
}
