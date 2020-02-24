let locPrime, locResult, locGenPrime;

window.onload = init();

function init(){
    locPrime = document.getElementById("prime");
    locGenPrime = document.getElementById("genPrime");
    locResult = document.getElementById("resultPrime");
}

function checkPrime(number){
    let arrayPrimes = [];
    let count = 0;
    let result = "";

    for(let i = 0; i < number; i++){
        arrayPrimes[i] = i + 2;
    }
    for(let i = 0; i < arrayPrimes.length; ++i){
        for(let j = 0; j < arrayPrimes.length; ++j){
            for(let n = 2; n < (number / 2); ++n) {
                if (parseInt((arrayPrimes[i])) === (n * parseInt(arrayPrimes[j]))) {
                    arrayPrimes[i] = false;
                }
            }
        }
    }


    for(let i = 0; i < arrayPrimes.length; i++){
        if(arrayPrimes[i] !== false){
            if(count === (number / 5)){
                break;
            }else {
                if(count === number / 5 - 1){
                    result += arrayPrimes[i];
                    count++;
                }else {
                    result += arrayPrimes[i] + ", ";
                    count++;
                }
            }
        }
    }
    locResult.innerHTML = result;
}

locGenPrime.addEventListener("click", function(){
    if(locPrime.value === ""){
        alert("Hãy nhập số lượng số nguyên tố mà bạn muốn in ra");
    }else {
        checkPrime(parseInt(locPrime.value) * 5)
    }
}, false);