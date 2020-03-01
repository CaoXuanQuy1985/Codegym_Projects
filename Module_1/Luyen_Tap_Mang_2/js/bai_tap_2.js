let locSource2, locReverse, locSourceArr, locResult2;
let str = "";

window.onload = init();

function init(){
    locSource2 = document.getElementById("sourceArr2");
    locReverse = document.getElementById("reverse");
    locResult2 = document.getElementById("result2");
    locSourceArr = document.getElementById("sourceArr2");
}

function makeid(length) {
    let result           = '';
    let characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let charactersLength = characters.length;
    for (let i = 0; i < length; i++ ) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
}

let source = makeid(10);

locSourceArr.innerHTML = source;

function reverse(str){
    let reverseStr = str.split("");

    return reverseStr.reverse();
}

locReverse.addEventListener("click", function(){
    locResult2.innerHTML = reverse(source);
}, false);