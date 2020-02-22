let locBtn, locWeight, locHeight;
let weight, height;
let locResult;

function init(){
    locBtn = document.getElementById("btn");
    locWeight = document.getElementById("weight");
    locHeight = document.getElementById("height");
    locResult = document.getElementById("result");
}

window.onload = init();

function checkBMI(weight, height){
    return weight / (height * height);
}

function setActive(id, bmi){
    let listElem = document.getElementsByTagName("td");
    for(let index = 0; index < listElem.length; index++){
        listElem[index].setAttribute("class", "");
    }
    document.getElementById(id).setAttribute("class", "active");
    locResult.value = bmi.toFixed(2);
}

locBtn.addEventListener("click", function(){
    let bmi;
    weight = parseFloat(locWeight.value);
    height = parseFloat(locHeight.value);
    bmi = checkBMI(weight, height);
    if(bmi < 18.5){
        setActive("ruw", bmi);
    }else{
        if(bmi < 25.0){
            setActive("rn", bmi);
        }else{
            if(bmi < 30.0){
                setActive("row", bmi);
            }else{
                setActive("rob", bmi);
            }
        }
    }
}, false);