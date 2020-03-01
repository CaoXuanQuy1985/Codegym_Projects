let locInputNumber, locCheck, locResult;
let primeSieve;

window.onload = init();

function init(){
    locInputNumber = document.getElementById("input-number");
    locCheck = document.getElementById("check");
    locResult = document.getElementById("result");
    primeSieve = new Array(10000);
}

function createPrimeSieve(){
    primeSieve.fill(true);

    primeSieve[0] = primeSieve[1] = false;
    for(let i = 2; i < primeSieve.length; i++){
        if(primeSieve[i]){
            for(let j = 2; (i * j) < primeSieve.length; j++){
                primeSieve[i * j] = false;
            }
        }
    }

    return primeSieve;
}

function checkPrime(number){
    return primeSieve[number];
}

createPrimeSieve();

locCheck.addEventListener("click", function(){
    let numCheck = parseInt(locInputNumber.value);
    locResult.innerHTML = checkPrime(numCheck) ? numCheck + " là số nguyên tố" : numCheck + " không phải là số nguyên tố";
}, false);

