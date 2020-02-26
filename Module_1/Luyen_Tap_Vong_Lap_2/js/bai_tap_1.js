let locNumFib, locBtn, locresultFib, result;

window.onload = init();

function init(){
    locNumFib = document.getElementById("numFib");
    locBtn = document.getElementById("btn");
    locresultFib = document.getElementById("resultFib");
}

function generate(num){
    let first = 0, second = 1, numFib;
    let count = 0;

    result = first + ", " + second + ", ";
    while(count < num){
        numFib = first + second;
        if(count === num - 1){
            result += numFib;
        }
        else{
            result += numFib + ", ";
        }
        first = second;
        second = numFib;
        count++;
    }

    locresultFib.innerHTML = result;
}

locBtn.addEventListener("click",function(){
    generate(parseInt(locNumFib.value));
}, false);