let locInputElem, locInsert, locResult;
let arrayResult;

window.onload = init();

function init(){
    locInputElem = document.getElementById("input-Elem");
    locResult = document.getElementById("result");
    locInsert = document.getElementById("insert");
    arrayResult = [];
}

function insert(array){
    let newArray = convertString(array);
    for(let i = 0; i < newArray.length; i++){
        if(((parseInt(newArray[i]) % 2) === 0) && ((parseInt(newArray[i + 1]) % 2) === 0)){
            newArray.splice(i + 1, 0, "-");
        }
    }

    let result = "";
    newArray.forEach(function(element){
        result += element;
    });

    locResult.innerHTML = result;
}

function convertString(str){
    let array = str.split("");
    return array;
}

locInsert.addEventListener("click", function(){
    insert(locInputElem.value)
}, false);

