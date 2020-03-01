let locGenerate, locSource, locResult;
let arr2Dim = [];
let table = "";

window.onload = init();

function init(){
    locGenerate = document.getElementById("generate");
    locResult = document.getElementById("result");
    locSource = document.getElementById("sourceArr");
}

function genArr1Dim(){
    let arrayInt = [];

    for(let i = 0; i < 4; i++){
        arrayInt.push(Math.floor(Math.random() * 20));
    }

    return arrayInt;
}

function genArr2Dim(){
    for(let i = 0; i < 5; i++){
        arr2Dim.push(genArr1Dim());
    }
}

function showArr2Dim(array2Dim){
    let arr2DimString = "";
    table += "<table>";
    for(let i = 0; i < array2Dim.length; i++){
        table += "<tr>";
        for(let j = 0; j < array2Dim[i].length; j++){
            arr2DimString += array2Dim[i][j] + " ";
            table += "<td>" + array2Dim[i][j] + "</td>";
        }
        table += "</tr>";
        arr2DimString += "<br/>";
    }
    table += "</table>";

    locSource.innerHTML = table;
}

genArr2Dim();

showArr2Dim(arr2Dim);

function showResult(arr2Dim){
    let result = "";

    for(let i = 0; i < arr2Dim.length; i++){
        result += "row[" + i + "]: <br/>";
        for(let j = 0; j < arr2Dim[i].length; j++){
            result += "&nbsp;&nbsp;&nbsp;&nbsp;" + arr2Dim[i][j] + "</br>";
        }
        result += "</br>";
    }

    locResult.innerHTML = result;
}

locGenerate.addEventListener("click", function(){
    showResult(arr2Dim)
}, false);